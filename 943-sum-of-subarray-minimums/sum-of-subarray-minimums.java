class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] next=nextsum(arr);
        int[] prev=prevsum(arr);
        int mod=1000000007;
        long count=0;
        for(int i=0;i<arr.length;i++){
           int first=i-prev[i];
           int second=next[i]-i;
           long prod=(first *second)%mod;
           prod=(prod*arr[i])%mod;
           count=(count%mod+prod)%mod;
        }
        return (int)count;

    }
    private int[] nextsum(int[] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int[] ans=new int[n];
        for(int i=arr.length-1;i>=0;i--){
           while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
            s.pop();
           }
           if(s.isEmpty()){
            ans[i]=arr.length;
           }
           else{
            ans[i]=s.peek();
           }
           s.push(i);
        }
        return ans;
    }

    private int[] prevsum(int[] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int[] ans=new int[n];
        for(int i=0;i<arr.length;i++){
           while(!s.isEmpty() && arr[s.peek()]>arr[i]){
            s.pop();
           }
           if(s.isEmpty()){
            ans[i]=-1;
           }
           else{
            ans[i]=s.peek();
           }
           s.push(i);
        }
        return ans;
    }
}