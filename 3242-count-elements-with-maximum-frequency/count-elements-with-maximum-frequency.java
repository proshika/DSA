class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : hm.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        int sum = 0;
        for (int freq : hm.values()) {
            if (freq == maxFreq) sum += freq;
        }
        return sum;
    }
}