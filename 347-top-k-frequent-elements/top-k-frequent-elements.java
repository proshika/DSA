class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k){
                minheap.remove();
            }
        }

        int i=0;
        while(!minheap.isEmpty()){
            ans[i++]=minheap.poll().getKey();
        }
        return ans;
    }
}