import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequency
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Put keys into list
        List<String> list = new ArrayList<>(map.keySet());

        // Step 3: Sort based on condition
        Collections.sort(list, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b); // lexicographical order
            }
            return map.get(b) - map.get(a); // higher frequency first
        });

        // Step 4: Return first k elements
        return list.subList(0, k);
    }
}