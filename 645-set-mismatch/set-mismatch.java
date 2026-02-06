class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int[] ans=new int[2];
         ans[0]=Duplicate(nums);
         ans[1]=Missing(nums);

         return ans;
    }
    private int Missing(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    private int Duplicate(int nums[]){
       Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}