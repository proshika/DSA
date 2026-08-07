class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[n+1];
        dp[1]=0;
        for(int i=1;i<n;i++){
            if(prices[i-1]<prices[i]){
                dp[i]=dp[i-1]+prices[i]-prices[i-1];
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1];
    }
}