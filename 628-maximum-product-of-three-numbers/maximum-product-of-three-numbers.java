class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int mult1=nums[n-1]*nums[n-2]*nums[n-3];
        int mult2=nums[0]*nums[1]*nums[n-1];

        return Math.max(mult1,mult2);
    }
}