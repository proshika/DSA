class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) return false;
        }
        return nums[n] == n;
    }
}