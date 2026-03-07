class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s; // Concatenate to handle rotations
        int res = n; // Minimum flips

        // Build two alternating patterns
        char[] alt1 = new char[2 * n];
        char[] alt2 = new char[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            alt1[i] = (i % 2 == 0) ? '0' : '1';
            alt2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int diff1 = 0, diff2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (s2.charAt(i) != alt1[i]) diff1++;
            if (s2.charAt(i) != alt2[i]) diff2++;

            if (i >= n) {
                if (s2.charAt(i - n) != alt1[i - n]) diff1--;
                if (s2.charAt(i - n) != alt2[i - n]) diff2--;
            }
            if (i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;
    }
}