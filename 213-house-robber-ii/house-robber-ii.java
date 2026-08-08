class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int option1 = robLinear(nums, 0, n - 2);
        int option2 = robLinear(nums, 1, n - 1);
        return Math.max(option1, option2);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length];
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }
        
        return dp[length - 1];
    }
}