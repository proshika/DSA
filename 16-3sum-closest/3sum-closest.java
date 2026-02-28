class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minClose=Integer.MAX_VALUE;
        int total=0;
        int closestsum=1000000000;
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                total=nums[i]+nums[j]+nums[k];
                if(total==target){
                    return total;
                }
                if(Math.abs(target-total)<Math.abs(target-closestsum)){
                    closestsum=total;
                }
                else if(total>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return closestsum;
    }
}