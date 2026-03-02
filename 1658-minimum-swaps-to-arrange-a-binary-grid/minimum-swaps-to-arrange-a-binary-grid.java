class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) zeroCount++;
                else break;
            }
            trailingZeros[i] = zeroCount;
        }
        
        int swaps = 0;
        // Step 2: For each row, find a row below with enough trailing zeros
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = i;
            while (j < n && trailingZeros[j] < required) j++;
            if (j == n) return -1; // Not possible
            
            // Bring up row j to position i by swapping with each row above it
            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                swaps++;
                j--;
            }
        }
        return swaps;
    }
}