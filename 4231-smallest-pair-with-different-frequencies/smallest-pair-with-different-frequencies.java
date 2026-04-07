import java.util.*;

class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        if (nums == null || nums.length < 2) return new int[]{-1, -1};
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        List<Integer> uniqueKeys = new ArrayList<>(hm.keySet());
        Collections.sort(uniqueKeys);

        for (int i = 0; i < uniqueKeys.size(); i++) {
            for (int j = i + 1; j < uniqueKeys.size(); j++) {
                int u1 = uniqueKeys.get(i);
                int u2 = uniqueKeys.get(j);
                
                if (!hm.get(u1).equals(hm.get(u2))) {
                    return new int[]{u1, u2};
                }
            }
        }

        return new int[]{-1, -1};
    }
}