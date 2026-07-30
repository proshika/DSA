class Solution {
    public int minSetSize(int[] arr) {
        int sum=0,count=0;
        int n=arr.length;
        int half=n/2;
        int[] freq=new int[100001];
        for(int num:arr){
            freq[num]++;
        }
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
            if(f>0){
               max.add(f);
            }
        }
        while(!max.isEmpty()){
            sum+=max.poll();
            count++;
            if(sum>=half){
                return count;
            }
        }
        return -1;
    }
}