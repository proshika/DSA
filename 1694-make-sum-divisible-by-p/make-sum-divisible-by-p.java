class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        int target = (int)(total % p);
        if (target == 0) return 0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        int res = nums.length, prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (prefix - target + p) % p;
            if (prefixMap.containsKey(need)) {
                res = Math.min(res, i - prefixMap.get(need));
            }
            prefixMap.put(prefix, i);
        }
        return res == nums.length ? -1 : res;
    }
}