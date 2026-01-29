class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        final int INF = (int)1e9;
        int[][] minCost = new int[26][26];

        // Initialize minCost
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) minCost[i][j] = 0;
                else minCost[i][j] = INF;
            }
        }

        // Fill minCost with direct conversion costs
        for (int i = 0; i < m; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        // Floyd-Warshall: all-pairs shortest path
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);
            if (s == t) continue;
            int from = s - 'a';
            int to = t - 'a';
            if (minCost[from][to] >= INF) return -1;
            total += minCost[from][to];
        }
        return total;
    }
}