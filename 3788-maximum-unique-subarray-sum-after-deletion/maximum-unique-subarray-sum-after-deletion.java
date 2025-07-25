class Solution {
    public int maxSum(int[] nums) {
       /*Set<Integer> set=new HashSet<>();
       int left=0;
       int maxsum=Integer.MIN_VALUE;
       int currsum=nums[0];
       for(int right=0;right<nums.length;right++){
        while(set.contains(nums[right])){
            set.remove(nums[left]);
             currsum-=nums[left];
            left++;
        }
        set.add(nums[right]);
        currsum+=nums[right];
        maxsum=Math.max(maxsum,currsum);
       }
       return maxsum;*/
       
       int max = Arrays.stream(nums).max().getAsInt();
        if (max <= 0) {
            return max;
        }
        boolean[] seen = new boolean[201];
        int result = 0; 
        for (int num : nums) {
            if (num < 0 || seen[num]) {
                continue;
            }
            result += num;
            seen[num] = true;
        }
        return result;
    }
}