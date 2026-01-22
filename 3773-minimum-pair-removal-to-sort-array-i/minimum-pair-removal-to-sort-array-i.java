class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        // Keep merging until the array is non-decreasing
        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int idx = -1;
            // Find the leftmost adjacent pair with the minimum sum
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            // Merge the pair at idx
            int[] next = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; ) {
                if (i == idx) {
                    next[j++] = nums[i] + nums[i + 1];
                    i += 2;
                } else {
                    next[j++] = nums[i++];
                }
            }
            nums = next;
            operations++;
        }
        return operations;
    }

    // Helper to check if the array is non-decreasing
    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }
}