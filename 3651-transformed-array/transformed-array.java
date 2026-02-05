class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[i] = nums[(i + nums[i] + n) % n];
            } else if (nums[i] < 0) {
                int idx=((i - Math.abs(nums[i]))%n+n)%n;
                result[i] = nums[ idx];
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}