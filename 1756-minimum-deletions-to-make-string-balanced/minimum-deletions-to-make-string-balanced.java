class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int minDeletion = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                bCount++;
            }
            if (ch == 'a') {
                minDeletion = Math.min(minDeletion + 1, bCount);
            }
        }
        return minDeletion;
    }
}