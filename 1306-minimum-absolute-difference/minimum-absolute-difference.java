class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            mindiff=Math.min(mindiff,diff);
        }
        for(int i=1;i<arr.length;i++){
            if(mindiff==arr[i]-arr[i-1]){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }
}