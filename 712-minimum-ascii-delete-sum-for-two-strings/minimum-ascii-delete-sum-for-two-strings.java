class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill base cases
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = getASCII(s1.charAt(i)) + dp[i + 1][n];
        }
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = getASCII(s2.charAt(j)) + dp[m][j + 1];
        }

        // Fill DP table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                        getASCII(s1.charAt(i)) + dp[i + 1][j],
                        getASCII(s2.charAt(j)) + dp[i][j + 1]
                    );
                }
            }
        }
        return dp[0][0];
    }

    private int getASCII(char c) {
        return (int) c;
    }
}