class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Directions for each street type
        int[][][] dirs = {
            {},
            {{0, -1}, {0, 1}},         // 1: left, right
            {{-1, 0}, {1, 0}},         // 2: up, down
            {{0, -1}, {1, 0}},         // 3: left, down
            {{0, 1}, {1, 0}},          // 4: right, down
            {{0, -1}, {-1, 0}},        // 5: left, up
            {{0, 1}, {-1, 0}}          // 6: right, up
        };

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            if (x == m - 1 && y == n - 1) return true;

            for (int[] dir : dirs[grid[x][y]]) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // Check if the next cell connects back to the current cell
                    for (int[] back : dirs[grid[nx][ny]]) {
                        if (nx + back[0] == x && ny + back[1] == y) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}