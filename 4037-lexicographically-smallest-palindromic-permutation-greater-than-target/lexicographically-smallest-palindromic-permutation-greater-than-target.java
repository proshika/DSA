class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check whether a palindrome is possible
        int oddCount = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        // More than one odd frequency -> impossible
        if (oddCount > 1) {
            return "";
        }

        // Frequency of characters in left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        String targetHalf = target.substring(0, halfLen);

        /*
         * First try to use exactly targetHalf.
         */
        if (canMake(targetHalf, halfFreq)) {

            String candidate = makePalindrome(targetHalf, middle);

            /*
             * IMPORTANT:
             * Compare the complete palindrome, not just
             * the left half or middle character.
             *
             * This handles cases such as:
             * s = "cc", target = "cb"
             * candidate = "cc" > "cb"
             */
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * targetHalf either:
         * 1. cannot be formed, OR
         * 2. produces a palindrome <= target.
         *
         * Therefore find the next lexicographically greater
         * possible left half.
         */
        String nextHalf = nextGreater(targetHalf, halfFreq);

        if (nextHalf == null) {
            return "";
        }

        return makePalindrome(nextHalf, middle);
    }


    // Checks whether targetHalf can be created from halfFreq
    private boolean canMake(String targetHalf, int[] halfFreq) {

        int[] remaining = halfFreq.clone();

        for (char c : targetHalf.toCharArray()) {

            int index = c - 'a';

            if (remaining[index] == 0) {
                return false;
            }

            remaining[index]--;
        }

        return true;
    }


    /*
     * Finds the smallest permutation of halfFreq
     * that is strictly greater than targetHalf.
     */
    private String nextGreater(String targetHalf, int[] halfFreq) {

        int len = targetHalf.length();

        /*
         * Try changing each position from right to left.
         *
         * Example:
         *
         * target = "abb"
         *
         * First try:
         * "ab_"
         *
         * If impossible:
         * "a__"
         *
         * etc.
         */
        for (int pivot = len - 1; pivot >= 0; pivot--) {

            int[] remaining = halfFreq.clone();

            boolean possible = true;

            /*
             * Keep everything before pivot equal
             * to targetHalf.
             */
            for (int i = 0; i < pivot; i++) {

                int index = targetHalf.charAt(i) - 'a';

                if (remaining[index] == 0) {
                    possible = false;
                    break;
                }

                remaining[index]--;
            }

            if (!possible) {
                continue;
            }

            int current = targetHalf.charAt(pivot) - 'a';

            /*
             * Put the smallest character greater than
             * targetHalf[pivot].
             */
            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    remaining[c]--;

                    StringBuilder result = new StringBuilder();

                    // Equal prefix
                    for (int i = 0; i < pivot; i++) {
                        result.append(targetHalf.charAt(i));
                    }

                    // Greater character
                    result.append((char) ('a' + c));

                    // Remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            result.append((char) ('a' + x));
                            remaining[x]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return null;
    }


    // Creates palindrome from left half + middle + reverse(left half)
    private String makePalindrome(String left, int middle) {

        StringBuilder result = new StringBuilder();

        result.append(left);

        // Odd length
        if (middle != -1) {
            result.append((char) ('a' + middle));
        }

        // Right half
        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }
}