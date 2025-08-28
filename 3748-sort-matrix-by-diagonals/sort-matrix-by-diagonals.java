class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Sort diagonals starting from each row (bottom-left + main diagonal)
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false); // false: non-increasing
        }
        // Sort diagonals starting from each column (top-right, skip main diagonal)
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true); // true: non-decreasing
        }
        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        // Collect the diagonal
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }
        // Sort as needed
        if (increasing) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }
        // Put back
        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}