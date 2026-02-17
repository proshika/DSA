class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Skip if already visited or zeroed out
            if (nums[i] == 0) continue;
            int slow = i, fast = i;
            // Check direction
            boolean isForward = nums[i] > 0;
            while (true) {
                slow = nextIndex(nums, isForward, slow);
                fast = nextIndex(nums, isForward, fast);
                if (fast != -1) fast = nextIndex(nums, isForward, fast);
                if (slow == -1 || fast == -1 || slow == fast) break;
            }
            if (slow != -1 && slow == fast) return true;
        }
        return false;
    }

    private int nextIndex(int[] nums, boolean isForward, int current) {
        boolean direction = nums[current] > 0;
        if (isForward != direction) return -1;
        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n; 
        if (next == current) return -1; 
        return next;
    }
}