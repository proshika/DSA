class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int shiftedIndex;
                if (i % 2 == 0) {
                    // Even row: shift left
                    shiftedIndex = (j + k) % cols;
                } else {
                    // Odd row: shift right
                    shiftedIndex = ((j - k) % cols + cols) % cols;
                }
                if (mat[i][j] != mat[i][shiftedIndex]) {
                    return false;
                }
            }
        }
        return true;
    }
}