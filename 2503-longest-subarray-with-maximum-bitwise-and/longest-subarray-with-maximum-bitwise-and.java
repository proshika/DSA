class Solution {
    public int longestSubarray(int[] nums) {
        int maxval=0;
        for(int i=0;i<nums.length;i++){
            maxval=Math.max(nums[i],maxval);
        }

        int maxlen=0;
        for(int i=0;i<nums.length;i++){
            int currlen=0;
            while(i<nums.length && nums[i]==maxval){
                currlen++;
                i++;
            }
             maxlen=Math.max(maxlen,currlen);

        }
        return maxlen;
    }
}