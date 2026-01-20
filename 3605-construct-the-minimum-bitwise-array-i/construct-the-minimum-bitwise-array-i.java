class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1; // Default to -1
            for (int x = 0; x <= nums.get(i); x++) {
                if ((x | (x + 1)) == nums.get(i)) {
                    ans[i] = x;
                    break;
                }
            }
        }
        return ans;
    }
}