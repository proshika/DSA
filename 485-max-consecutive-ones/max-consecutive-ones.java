class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                max=Math.max(max,right-left);
                left=right+1;
            }
        }  
        return Math.max(max, nums.length - left);
    }
}