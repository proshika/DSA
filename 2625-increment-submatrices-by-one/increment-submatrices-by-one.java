class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int matrix[][]=new int[n][n];
        int r1=0,c1=0,r2=0,c2=0;
        for(int row=0;row<queries.length;row++){
            for(int col=0;col<queries[0].length-3;col++){
                r1=queries[row][col+0];
                c1=queries[row][col+1];
                r2=queries[row][col+2];
                c2=queries[row][col+3];
                submatrix(r1,c1,r2,c2,matrix);
            }
        }
        return matrix;
    }
    public void submatrix(int r1,int c1,int r2,int c2,int matrix[][]){
        for(int row=r1;row<=r2;row++){
            for(int col=c1;col<=c2;col++){
                matrix[row][col]+=1;
            }
        }
    }
}