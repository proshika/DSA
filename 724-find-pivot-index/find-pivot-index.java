class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int rightsum=0;
        for(int num:nums){
            rightsum+=num;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            rightsum-=nums[i];
            if(leftsum==rightsum){
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
}