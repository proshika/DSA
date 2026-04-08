class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int mod = (int) 1e9 + 7;
        int n=nums.length;
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];
            for(int j=l;j<=r;j+=k){
                nums[j]=(int) (1L *nums[j]*v %mod);
            }
        }
        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}