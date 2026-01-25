class Solution {
    public int minimumDifference(int[] nums, int k) {
        int mindiff=Integer.MAX_VALUE;
        int diff=0;
        Arrays.sort(nums);
        if(nums.length==1){
            return 0;
        }
        for(int i=0;i<=nums.length-k;i++){
           diff=nums[i+k-1]-nums[i];
            mindiff=Math.min(mindiff,diff);
        }
        return mindiff;
    }
}