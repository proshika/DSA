class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                boolean[][] vis = new boolean[row][col];
                if (dfs(board, word, 0, i, j, vis)) return true;       }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int idx,int row,int col,boolean[][] vis){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        if(idx==word.length()){
            return true;
        }
        if(row<0 ||row>=board.length ||col<0||col>=board[0].length|| vis[row][col]==true || board[row][col]!=word.charAt(idx)){
            return false;
        }
        vis[row][col]=true;
        for(int d=0;d<4;d++){
            int newRow = row + dx[d];
            int newCol = col + dy[d];
            if(dfs(board,word,idx+1,newRow,newCol,vis)) return true;
        }
        vis[row][col]=false;
        return false;
    }
}