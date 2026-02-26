class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        if(total%2!=0){
            return false;
        }
        total=total/2;

        boolean[] dp=new boolean[total+1];
        dp[0]=true;
        for(int i:nums){
            for(int j=total;j>=i;j--){
                dp[j]=dp[j] || dp[j-i];
            }
        }
        return dp[total];
    }
}