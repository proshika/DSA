class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];
        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];

        // Initialize
        Arrays.fill(minX, n + 1);
        Arrays.fill(minY, n + 1);
        Arrays.fill(maxX, 0);
        Arrays.fill(maxY, 0);

        // Update min/max for each row and column
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);
        }

        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (x > minX[y] && x < maxX[y] && y > minY[x] && y < maxY[x]) {
                count++;
            }
        }
        return count;
    }
}