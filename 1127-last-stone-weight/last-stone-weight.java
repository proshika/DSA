class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            max.add(stone);
        }
        while(max.size()>1){
            int x=max.remove();
            int y=max.remove();
            if(x!=y){
               max.offer(x-y);
            }
        }
        return max.isEmpty()?0:max.peek();
    }
}

//TC=O(nlogn)
//SC=O(n)
