class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, idx = 0;
        List<List<Integer>> diagonals = new ArrayList<>();
        for (int i = 0; i < m + n - 1; i++) diagonals.add(
            new ArrayList<>());
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                diagonals.get(i + j).add(mat[i][j]);
        int[] res = new int[m * n];
        for (int k = 0; k < diagonals.size(); k++) {
            List<Integer> diag = diagonals.get(k);
            if (k % 2 == 0) Collections.reverse(diag);
            for (int num : diag) res[idx++] = num;
        }
        return res;
    }
}