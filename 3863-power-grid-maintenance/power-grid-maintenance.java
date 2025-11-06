class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int idx = 0;

        // DSU setup
        int[] parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;
        // Build DSU
        for (int[] conn : connections) {
            union(parent, conn[0], conn[1]);
        }

        // Map root -> TreeSet of online stations
        Map<Integer, TreeSet<Integer>> online = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(parent, i);
            online.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        // Online status
        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = find(parent, x);
            if (type == 1) {
                if (isOnline[x]) {
                    ans.add(x);
                } else {
                    TreeSet<Integer> set = online.get(root);
                    Integer min = set == null || set.isEmpty() ? null : set.first();
                    ans.add(min == null ? -1 : min);
                }
            } else {
                if (isOnline[x]) {
                    isOnline[x] = false;
                    TreeSet<Integer> set = online.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }
        // Only return answers for type 1 queries
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x), py = find(parent, y);
        if (px != py) parent[px] = py;
    }
}