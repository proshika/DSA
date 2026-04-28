class Solution {
    public boolean search(int[] nums,int tar) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==tar){
                return true;
            }
            if(nums[left]==nums[mid] && nums[mid]==nums[right]){
                left++;
                right--;
            }
            else if(nums[mid]>=nums[left]){
                if(tar>=nums[left] && tar<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            else{
                if(tar>=nums[mid] && tar<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}