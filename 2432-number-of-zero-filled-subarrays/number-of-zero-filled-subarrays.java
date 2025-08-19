class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result=0;
        long count=0;
        
        for(int num:nums){
            count=(num==0)?count+1:0;
            result+=count;
        }
        return result;
    }
}