class Solution {
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
      
        for (int num : nums) {
            rightSum += num;
        }
        int partitionCount = 0;
      
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if ((leftSum - rightSum) % 2 == 0) {
                partitionCount++;
            }
        }
      
        return partitionCount;
    }
}