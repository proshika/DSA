class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Stack<int[]> s = new Stack<>(); // Each element: [num, steps]
        int maxSteps = 0;

        for (int i = n - 1; i >= 0; i--) {
            int step = 0;
            while (!s.isEmpty() && nums[i] > s.peek()[0]) {
                step = Math.max(step + 1, s.peek()[1]);
                s.pop();
            }
            s.push(new int[]{nums[i], step});
            maxSteps = Math.max(maxSteps, step);
        }
        return maxSteps;
    }
}