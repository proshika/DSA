class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            boolean shouldSkip = false;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    shouldSkip = true;
                    break;
                }
            }
            if (!shouldSkip) {
                count++;
            }
        }
        return count;
    }
}