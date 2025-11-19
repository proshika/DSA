class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Keep checking as long as original is found in nums
        boolean found = true;
        while (found) {
            found = false;
            for (int num : nums) {
                if (num == original) {
                    original *= 2;
                    found = true;
                    break; // Only need to multiply once per round
                }
            }
        }
        return original;
    }
}