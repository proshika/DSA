class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // To handle subarrays starting from index 0
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int rem = k != 0 ? prefix % k : prefix;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) return true; // Subarray length at least 2
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}