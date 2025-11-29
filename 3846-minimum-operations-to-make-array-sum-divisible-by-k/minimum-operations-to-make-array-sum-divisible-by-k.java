class Solution {
    public int minOperations(int[] nums, int k) {
       int totalSum = Arrays.stream(nums).sum();//Arrays.stream(nums) turns your nums array into a stream (think of it like lining up all the numbers, one after another).sum() adds up all those numbers in the stream.

        return totalSum % k;

    }
}