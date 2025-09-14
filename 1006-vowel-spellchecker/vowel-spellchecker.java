import java.util.*;

class Solution {
    // Helper function to replace vowels with '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        // Build lookup structures
        for (String word : wordlist) {
            exactSet.add(word);
            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);
            String devoweled = devowel(word);
            vowelMap.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // 1. Exact match
            if (exactSet.contains(query)) {
                result[i] = query;
                continue;
            }

            // 2. Case-insensitive match
            String lower = query.toLowerCase();
            if (caseMap.containsKey(lower)) {
                result[i] = caseMap.get(lower);
                continue;
            }

            // 3. Vowel-error match
            String devoweled = devowel(query);
            if (vowelMap.containsKey(devoweled)) {
                result[i] = vowelMap.get(devoweled);
                continue;
            }

            // 4. No match
            result[i] = "";
        }
        return result;
    }
}