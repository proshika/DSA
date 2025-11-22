class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        int sum=0,diff=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]%3)!=0){
                sum+=1;
                diff-=1;
                count++;
            }
        }
        return count;
    }
}