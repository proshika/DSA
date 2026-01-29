class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To count subarrays starting at index 0
        int runningSum = 0, count = 0;
        for (int num : nums) {
            runningSum += num;
            int rem = (runningSum % k + k) % k; // Handles negative numbers
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}