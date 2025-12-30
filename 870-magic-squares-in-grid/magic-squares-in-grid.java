class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][] grid, int row, int col) {
        // Check for numbers 1-9 and uniqueness
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];
                if (val < 1 || val > 9 || seen[val])
                    return false;
                seen[val] = true;
            }
        }
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            int rSum = 0, cSum = 0;
            for (int j = 0; j < 3; j++) {
                rSum += grid[row + i][col + j];
                cSum += grid[row + j][col + i];
            }
            if (rSum != 15 || cSum != 15)
                return false;
        }
        // Check diagonals
        int d1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int d2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (d1 != 15 || d2 != 15)
            return false;

        return true;
    }
}
