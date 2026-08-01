class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        
        return maxDiff(nums, 0, n - 1, memo) >= 0;
    }
    
    private int maxDiff(int[] nums, int left, int right, Integer[][] memo) {
        // Base case: only one number left, the current player must take it
        if (left == right) {
            return nums[left];
        }
        
        // Return the score if we already calculated it before
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        
        // Option 1: Take the left number. The opponent gets to play on the remaining range.
        int pickLeft = nums[left] - maxDiff(nums, left + 1, right, memo);
        
        // Option 2: Take the right number. The opponent gets to play on the remaining range.
        int pickRight = nums[right] - maxDiff(nums, left, right - 1, memo);
        
        // Store and return the best choice for the current player
        memo[left][right] = Math.max(pickLeft, pickRight);
        return memo[left][right];
    }
}