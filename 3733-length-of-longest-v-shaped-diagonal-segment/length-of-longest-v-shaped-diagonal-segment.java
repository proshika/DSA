class Solution {
    // Directions: [down-right, down-left, up-left, up-right]
    private static final int[][] DIRS = {{1,1},{1,-1},{-1,-1},{-1,1}};
    // Clockwise turn: 0->1, 1->2, 2->3, 3->0
    private static final int[] TURN = {1,2,3,0};
    private int n, m, maxLen;
    private int[][] grid;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        dfs(i, j, d, 0, 1, true);
                    }
                }
            }
        }
        return maxLen;
    }

    // idx: current sequence index (0:2, 1:0, 2:2, 3:0...)
    private void dfs(int x, int y, int dir, int idx, int len, boolean canTurn) {
        maxLen = Math.max(maxLen, len);

        int nx = x + DIRS[dir][0];
        int ny = y + DIRS[dir][1];
        int expected = (idx % 2 == 0) ? 2 : 0;

        // First, keep going straight as far as possible
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == expected) {
            dfs(nx, ny, dir, idx + 1, len + 1, canTurn);
        }
        // Then, at every step, try turning if allowed
        if (canTurn) {
            int newDir = TURN[dir];
            int tx = x + DIRS[newDir][0];
            int ty = y + DIRS[newDir][1];
            if (tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == expected) {
                dfs(tx, ty, newDir, idx + 1, len + 1, false);
            }
        }
    }
}