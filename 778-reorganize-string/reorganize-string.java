class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char str : s.toCharArray()) {
            freq[str - 'a']++;
        }
        PriorityQueue<Character> max = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);

        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c - 'a'] > 0) {
                max.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (max.size() > 1) {
            char first = max.remove();
            char second = max.remove();

            sb.append(first);
            sb.append(second);

            freq[first - 'a']--;
            freq[second - 'a']--;

            if (freq[first - 'a'] > 0) {
                max.add(first);
            }
            if (freq[second - 'a'] > 0) {
                max.add(second);
            }
        }
        if (!max.isEmpty()) {
            char last = max.poll();
            if (freq[last - 'a'] > 1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}