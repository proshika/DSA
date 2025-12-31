class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                queue.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r == row - 1) return true;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    grid[nr][nc] == 0 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
}