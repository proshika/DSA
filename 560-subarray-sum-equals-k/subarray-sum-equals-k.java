class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int count = 0,prefix=0;
        for (int num:nums ) {
            prefix+=num;
            if (hm.containsKey(prefix- k)) {
                count += hm.get(prefix- k);
            }
            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}