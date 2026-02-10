class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int start = 0; start < n; start++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();
            for (int end = start; end < n; end++) {
                if (nums[end] % 2 == 0) {
                    evenSet.add(nums[end]);
                } else {
                    oddSet.add(nums[end]);
                }
                if (evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }
}