class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int swaps = 0;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            int partner = first ^ 1; // Partner: 0^1=1, 1^1=0, 2^1=3, 3^1=2, etc.

            if (row[i + 1] != partner) {
                swaps++;

                int partnerIndex = pos[partner];

                row[partnerIndex] = row[i + 1];
                pos[row[i + 1]] = partnerIndex;

                row[i + 1] = partner;
                pos[partner] = i + 1;
            }
        }

        return swaps;
    }
}