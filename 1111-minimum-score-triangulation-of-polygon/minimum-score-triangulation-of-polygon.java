/*class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        return helper(values,0,n-1);
    }
    private int helper(int values[],int i,int j){
        if(i+1==j){
            return 0;
        }
       int ans=Integer.MAX_VALUE;
       for(int k=i+1;k<j;k++){
        ans=Math.min(ans,values[i]*values[j]*values[k]+helper(values,i,k)
         + helper(values,k,j));
       }
       return ans;
    }
}
*/

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        // We fill the table for all possible lengths of sub-polygons (at least 3 vertices)
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try every possible k between i and j to split the polygon
                for (int k = i + 1; k < j; k++) {
                    int score = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }
        // The answer for the whole polygon is dp[0][n-1]
        return dp[0][n-1];
    }
}