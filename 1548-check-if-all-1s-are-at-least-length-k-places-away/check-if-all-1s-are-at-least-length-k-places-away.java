class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastindex=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(lastindex!=-1 && i-lastindex<=k){
                    return false;
                }
                lastindex=i;
            }
        }
        return true;
    }
}