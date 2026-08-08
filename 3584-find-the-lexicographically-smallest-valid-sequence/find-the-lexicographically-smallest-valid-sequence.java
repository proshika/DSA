class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // last[i] stores the index in word2 that can be matched 
        // by the suffix of word1 starting at index i.
        int[] last = new int[n + 1];
        last[n] = m;
        
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            last[i] = j + 1;
        }
        
        int[] result = new int[m];
        boolean usedChange = false;
        j = 0; // pointer for word2
        
        for (int i = 0; i < n; i++) {
            if (j == m) {
                break;
            }
            
            // Case 1: Characters match naturally
            if (word1.charAt(i) == word2.charAt(j)) {
                result[j] = i;
                j++;
            } 
            // Case 2: Mismatch, but we can use our one-time change
            else if (!usedChange && last[i + 1] <= j + 1) {
                result[j] = i;
                j++;
                usedChange = true;
            }
        }
        
        // If we matched the entire word2, return the indices. Otherwise, return empty.
        return j == m ? result : new int[0];
    }
}