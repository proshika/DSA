class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n + 1][k + 1];

        // Base case: one group (k = 1)
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }

        // Fill dp for more groups
        for (int g = 2; g <= k; g++) {
            for (int i = g; i <= n; i++) {
                for (int j = g - 1; j < i; j++) {
                    dp[i][g] = Math.max(dp[i][g],
                        dp[j][g - 1] + (prefix[i] - prefix[j]) / (i - j));
                }
            }
        }
        return dp[n][k];
    }
}