import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            // Count frequencies in the window
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            // Prepare a list of elements for custom sorting
            List<Integer> elements = new ArrayList<>(freq.keySet());
            elements.sort((a, b) -> {
                if (!freq.get(a).equals(freq.get(b))) {
                    return freq.get(b) - freq.get(a); // Descending frequency
                } else {
                    return b - a; // Descending value
                }
            });
            // Collect top x elements
            Set<Integer> topX = new HashSet<>();
            for (int t = 0; t < Math.min(x, elements.size()); t++) {
                topX.add(elements.get(t));
            }
            // Sum up only the numbers in topX
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (topX.contains(nums[j])) sum += nums[j];
            }
            answer[i] = sum;
        }
        return answer;
    }
}