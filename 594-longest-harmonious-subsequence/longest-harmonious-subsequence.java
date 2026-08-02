class Solution {
    public int findLHS(int[] nums) {
        int left=0;
        int len=0;
        Arrays.sort(nums);
        for(int right=0;right<nums.length;right++){
            if(Math.abs(nums[left]-nums[right])==1){
                len=Math.max(len,right-left+1);
            }
            while(nums[right]-nums[left]>1){
                left++;
            }
            
        }
        return len;
    }
}