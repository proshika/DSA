class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            if(heights[i+1]>heights[i]){
                int diff=heights[i+1]-heights[i];
                min.offer(diff);
                if(min.size()>ladders){
                   bricks-=min.poll();
                }
                if(bricks<0){
                    return i;
                }
            }
        }
        return heights.length-1;
    }
}