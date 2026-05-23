class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0;
        int right = tokens.length - 1;
        int count = 0;
        int max = 0;
        Arrays.sort(tokens);
        while (left <= right) {
            if (tokens[left] <= power) {
                count++;
                power = power - tokens[left];
                left++;
            } else if (count > 0 && left < right) {
                count--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}