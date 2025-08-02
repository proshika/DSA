class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int[][] time=new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    dfs(grid,time,i,j,0);
                }
            }
        }
        int reqtime=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    if(time[i][j]==Integer.MAX_VALUE) return -1;
                    reqtime=Math.max(reqtime,time[i][j]);
                }
            }
        }
        return reqtime;
    }
    private void dfs(int[][] grid,int[][] time,int i,int j,
    int currtime){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length
         || grid[i][j]==0 || currtime>=time[i][j]){
            return ;
        }
        time[i][j]=currtime;
         dfs(grid,time,i+1,j,currtime+1);
         dfs(grid,time,i-1,j,currtime+1);
         dfs(grid,time,i,j+1,currtime+1);
         dfs(grid,time,i,j-1,currtime+1);
        
    }
}