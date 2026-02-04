class Solution {
    public int findPeakElement(int[] nums) {
       int left=1,right=nums.length-1;
       int n=nums.length-1;
       if(n==0) return 0;
       if(nums[0]>nums[1]) return 0;
       if(nums[n]>nums[n-1]) return n;
       int mid;
       while(left<=right){
        mid=left+(right-left)/2;
        if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
            return mid;
        }
        if(nums[mid]<nums[mid+1]){
            left=mid+1;
        }else if(nums[mid]<nums[mid-1]){
            right=mid-1;
        }
        else{
            return mid;
        }
       }
       return -1;
    }
}