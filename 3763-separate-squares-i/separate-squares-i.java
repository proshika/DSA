class Solution {
    public double separateSquares(int[][] squares) {
        // Binary search between lowest and highest possible y
        double left = 0, right = 1e9 + 1, eps = 1e-6;

        // Precompute minY and maxY to limit search range
        for (int[] sq : squares) {
            left = Math.min(left, sq[1]);
            right = Math.max(right, sq[1] + sq[2]);
        }

        while (right - left > eps) {
            double mid = (left + right) / 2;
            double above = 0, below = 0;
            for (int[] sq : squares) {
                double y = sq[1], l = sq[2];
                double top = y + l;
                if (mid <= y) {
                    above += l * l;
                } else if (mid >= top) {
                    below += l * l;
                } else {
                    above += (top - mid) * l;
                    below += (mid - y) * l;
                }
            }
            if (above > below) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}