class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int right = (startIndex + i) % n;
            int left = (startIndex - i + n) % n;

            if (words[right].equals(target) || words[left].equals(target)) {
                min = i;
                break;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}