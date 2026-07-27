class Solution {
    public int maxProduct(int[] nums) {
        int mult=0;
        int n=nums.length;
        Arrays.sort(nums);
        mult=(nums[n-1]-1)*(nums[n-2]-1);
        return mult;
    }
}