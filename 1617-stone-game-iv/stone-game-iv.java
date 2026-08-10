class Solution {
    public boolean winnerSquareGame(int n) {
        if (n == 1)
            return true;
        if (n == 2)
            return false;
        boolean[] dp = new boolean[n+1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i * i <= j; i++) {
                if (!dp[j - i * i]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}