class Solution {
    public int minimumCost(int[] nums) {
        int ans=0;
        int minans=Integer.MAX_VALUE;
        for(int i=1;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                ans=nums[0]+nums[i]+nums[j];
                if(ans<minans){
                    minans=ans;
                }
            }
        }
        return minans;
    }
}