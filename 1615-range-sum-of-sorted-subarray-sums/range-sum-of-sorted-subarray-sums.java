class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod=1_000_000_007;
        int idx=0;
        int[] prefix=new int[n * (n + 1) / 2];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                prefix[idx++]=sum;
            }
        }
        Arrays.sort(prefix);
        long result=0;
        for(int i=left-1;i<right;i++){
            result=(result+prefix[i])%mod;;
        }
        return (int) result;
    }
}