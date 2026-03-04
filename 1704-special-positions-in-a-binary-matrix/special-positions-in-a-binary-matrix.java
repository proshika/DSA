class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    boolean isSpecial = true;
                    for (int k = 0; k < col; k++) {
                        if (k != j && mat[i][k] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    for (int k = 0; k < row; k++) {
                        if (k != i && mat[k][j] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (isSpecial)
                        count++;
                }
            }
        }
        return count;
    }
}