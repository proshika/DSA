class Solution {
    int M=1000000007;
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> power=new ArrayList<>();
        for(int i=0;i<32;i++){
            if((n & (1<<i))!=0){
                power.add(1<<i);
            }
        }
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long prod=1;
            int start=queries[i][0];
            int end=queries[i][1];
            for(int j=start;j<=end;j++){
                prod=(prod*power.get(j))%M;
            }
             result[i]=(int) prod;
        }
        return result;
    }
}