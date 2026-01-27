class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        int n=intervals.length;
        int count=0;
        int lastindex=intervals[0][1];
        for(int i=1;i<n;i++){
           if(lastindex<=intervals[i][0]){
            lastindex=Math.max(lastindex,intervals[i][1]);
           }
           else{
            count++;
           }
        }
        return count;
    }
}