class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i, dp));
        }
        return ans;
    }
    
    private int dfs(int[] arr, int d, int i, int[] dp) {
        if(dp[i] != 0) return dp[i];
        int res = 1;
        for(int j = i + 1; j <= i + d && j < arr.length && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + dfs(arr, d, j, dp));
            if(arr[j] >= arr[i]) break;
        }
        for(int j = i - 1; j >= i - d && j >= 0 && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + dfs(arr, d, j, dp));
            if(arr[j] >= arr[i]) break;
        }
        dp[i] = res;
        return res;
    }
}