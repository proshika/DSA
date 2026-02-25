class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=nums[0];

        for(int i=1;i<n;i++){
            if(i>=2){
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            }else{
                dp[i]=Math.max(dp[i-1],nums[i]);
            }
        }
        return dp[n-1];
        
    }
}