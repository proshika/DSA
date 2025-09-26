class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        // Start with the last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        // Bottom-up calculation
        for (int layer = n - 2; layer >= 0; layer--) {
            for (int i = 0; i <= layer; i++) {
                dp[i] = triangle.get(layer).get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}