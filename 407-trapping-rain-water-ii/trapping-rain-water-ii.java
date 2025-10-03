class Solution {
    public int trapRainWater(int[][] heightMap) {
        int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
        int row=heightMap.length;
        int cols=heightMap[0].length;
        int totalUnvisitedCells=row+cols;
        boolean[][] visited=new boolean[row][cols];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));

        for(int i=0;i<row;i++){
            pq.offer(new int[]{heightMap[i][0],i,0});
            pq.offer(new int[]{heightMap[i][cols-1],i,cols-1});
            visited[i][0]=true;
            visited[i][cols-1]=true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        for(int i=1;i<cols-1;i++){
            pq.offer(new int[]{heightMap[0][i],0,i});
            pq.offer(new int[]{heightMap[row-1][i],row-1,i});
            visited[0][i]=true;
            visited[row-1][i]=true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }
        int trappedwater=0;
        int waterlevel=0;

        while(!pq.isEmpty()){
            int currentCell[]=pq.poll();
            int currentHeight=currentCell[0];
            int currentRow=currentCell[1];
            int currentCol=currentCell[2];
            waterlevel=Math.max(waterlevel,currentHeight);

            for(int direction=0;direction<4;direction++){
                int neighborRow=currentRow+dir[direction][0];
                int neighborCol=currentCol+dir[direction][1];

                if(isValidCell(neighborRow,neighborCol,row,cols)&& !visited[neighborRow]
                [neighborCol]){
                    int neighborHeight=heightMap[neighborRow][neighborCol];
                    if(neighborHeight<waterlevel){
                        trappedwater+=waterlevel-neighborHeight;
                    }
                    pq.offer(new int[]{neighborHeight,neighborRow,neighborCol});
                    visited[neighborRow][neighborCol]=true;
                    totalUnvisitedCells--;
                }
            }
        }
        return trappedwater;
    }
    private boolean isValidCell(int row,int col,int rows,int cols){
        return row>=0 && col>=0 && row<rows && col<cols;
    }
}