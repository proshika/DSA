class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                totalSum += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
                if (val < 0) negCount++;
            }
        }

        // If the number of negatives is even, we can make all positive
        // If odd, one will remain negative (the smallest absolute value)
        if (negCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2L * minAbs;
        }
    }
}