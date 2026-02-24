class Solution {
    public int climbStairs(int n) {
        /* if (n <= 2) {
            return n;
        }
        int prev1=climbStairs(n-1);
        int prev2=climbStairs(n-2);
        
        return prev1+prev2;
        
        OR
        */

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}