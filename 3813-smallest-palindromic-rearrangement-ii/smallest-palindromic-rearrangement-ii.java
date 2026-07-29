import java.util.HashMap;
import java.util.Map;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Check if a palindrome is even possible
        int oddCount = 0;
        String midChar = "";
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount++;
                midChar = String.valueOf(entry.getKey());
            }
        }
        if (oddCount > 1) {
            return "";
        }

        Map<Character, Integer> halfCountsDict = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            halfCountsDict.put(entry.getKey(), entry.getValue() / 2);
        }

        int halfLen = n / 2;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        class Helper {
            long calculatePerms(Integer[] countsTuple, int length, long limit) {
                if (length < 0) return 0;
                if (length == 0) return 1;

                long p = 1;
                int remLen = length;
                for (int count : countsTuple) {
                    if (count < 0 || count > remLen) {
                        return 0;
                    }

                    if (count > 0) {
                        long comb = combinations(remLen, count, limit);
                        
                        if (comb > limit) return limit + 1;

                        if (p > (double) limit / comb && comb != 0) {
                            return limit + 1;
                        }

                        p *= comb;
                        if (p > limit) {
                            return limit + 1;
                        }

                        remLen -= count;
                    }
                }
                return p;
            }
            
            long combinations(int n, int k, long limit) {
                if (k < 0 || k > n) return 0;
                if (k == 0 || k == n) return 1;
                if (k > n / 2) {
                    k = n - k;
                }

                long result = 1;
                for (int i = 1; i <= k; ++i) {
                    // Safe overflow check before multiplying
                    if (result > (double) limit * i / (n - i + 1)) {
                        return limit + 1;
                    }
                    result = result * (n - i + 1) / i;
                }
                return result;
            }
        }
        Helper helper = new Helper();

        Integer[] initialCountsList = new Integer[26];
        for (int i = 0; i < 26; i++) {
            initialCountsList[i] = 0;
        }
        for (Map.Entry<Character, Integer> entry : halfCountsDict.entrySet()) {
            initialCountsList[entry.getKey() - 'a'] = entry.getValue();
        }
        Integer[] initialCountsTuple = initialCountsList;

        long totalPerms = helper.calculatePerms(initialCountsTuple, halfLen, k);

        if (k > totalPerms) {
            return "";
        }

        k -= 1;

        StringBuilder halfStr = new StringBuilder();
        Integer[] currentCountsList = initialCountsTuple.clone();

        for (int i = 0; i < halfLen; i++) {
            int lengthOfSuffix = halfLen - 1 - i;

            for (int charIdx = 0; charIdx < 26; charIdx++) {
                if (currentCountsList[charIdx] > 0) {
                    currentCountsList[charIdx] -= 1;

                    long permsCount = helper.calculatePerms(currentCountsList, lengthOfSuffix, k);

                    if (k < permsCount) {
                        halfStr.append(alphabet.charAt(charIdx));
                        break;
                    } else {
                        k -= permsCount;
                        currentCountsList[charIdx] += 1;
                    }
                }
            }
        }

        String halfStrString = halfStr.toString();
        return halfStrString + midChar + new StringBuilder(halfStrString).reverse().toString();
    }
}