class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);
        int n = robots.size(), m = factories.length;
        Long[][][] dp = new Long[n + 1][m + 1][101];

        return dfs(robots, factories, 0, 0, 0, dp);
    }

    private long dfs(List<Integer> robots, int[][] factories, int i, int j, int used, Long[][][] dp) {
        if (i == robots.size()) return 0;
        if (j == factories.length) return Long.MAX_VALUE / 2;
        if (dp[i][j][used] != null) return dp[i][j][used];

        // Option 1: Skip this factory
        long res = dfs(robots, factories, i, j + 1, 0, dp);

        // Option 2: Assign current robot to this factory (if capacity allows)
        if (used < factories[j][1]) {
            long dist = Math.abs(robots.get(i) - factories[j][0]);
            res = Math.min(res, dist + dfs(robots, factories, i + 1, j, used + 1, dp));
        }
        return dp[i][j][used] = res;
    }
}