class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxLen = 0;
        for (int val : dp) maxLen = Math.max(maxLen, val);
        return m - maxLen;
    }
}