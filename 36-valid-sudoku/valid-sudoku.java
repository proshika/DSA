class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) return false;
                }
                // Check column
                if (board[j][i] != '.') {
                    if (!col.add(board[j][i])) return false;
                }
                // Check box
                int boxRow = 3 * (i / 3) + (j / 3);
                int boxCol = 3 * (i % 3) + (j % 3);
                if (board[boxRow][boxCol] != '.') {
                    if (!box.add(board[boxRow][boxCol])) return false;
                }
            }
        }
        return true;
    }
}