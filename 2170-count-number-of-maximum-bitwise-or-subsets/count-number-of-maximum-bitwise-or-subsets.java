class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxor=0;
        for(int num:nums){
            maxor=maxor|num;
        }
        return helper(nums,0,maxor,0);
    }
    private int helper(int[] nums,int index,int maxor,int curror){
        if(index>=nums.length){
            return curror==maxor?1:0;
        }
        int take=helper(nums,index+1,maxor,curror|nums[index]);
        int nottake=helper(nums,index+1,maxor,curror);
        return take + nottake;
    }
}