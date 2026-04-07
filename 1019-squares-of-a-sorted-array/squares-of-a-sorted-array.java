class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int left=0,right=n-1,pos=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                ans[pos]=nums[left]*nums[left];
                left++;
            }
            else {
                ans[pos]=nums[right]*nums[right];
                right--;
            }
            pos=pos-1;
        }

        return ans;
    }
}