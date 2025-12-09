class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        long result = 0;

        // For each j, count how many i < j and k > j satisfy the condition
        Map<Integer, Integer> leftCount = new HashMap<>();
        Map<Integer, Integer> rightCount = new HashMap<>();

        // Fill rightCount with frequencies of all numbers
        for (int num : nums) {
            rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            // Current number at j will be the "middle" of the triplet
            rightCount.put(nums[j], rightCount.get(nums[j]) - 1);

            int doubleNum = nums[j] * 2;
            int left = leftCount.getOrDefault(doubleNum, 0);
            int right = rightCount.getOrDefault(doubleNum, 0);

            result = (result + (long) left * right) % MOD;

            leftCount.put(nums[j], leftCount.getOrDefault(nums[j], 0) + 1);
        }

        return (int) result;
    }
}