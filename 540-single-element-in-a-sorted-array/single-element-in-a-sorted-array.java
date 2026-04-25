class Solution {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                ans= entry.getKey();
            }
        }
        return ans;
    }
}