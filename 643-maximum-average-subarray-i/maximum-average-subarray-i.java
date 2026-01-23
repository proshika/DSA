class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double ans=0;
        double max=0;
        for(int i=0;i<k;i++){
            ans+=nums[i];
        }
        max=ans;
        for(int i=1;i<=n-k;i++){
            ans=ans-nums[i-1];
            ans=ans+nums[i+k-1];
            max=Math.max(max,ans);
        }
        return max/k;
    }
}