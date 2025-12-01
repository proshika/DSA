class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = 0;
        for (int battery : batteries) {
            right += battery;
        }
        while (left < right) {
            // Calculate mid point (use +1 to avoid infinite loop when left and right are adjacent)
            long mid = (left + right + 1) >> 1;

            // Calculate total usable battery capacity at runtime 'mid'
            // Each battery can contribute at most 'mid' minutes
            long totalUsableCapacity = 0;
            for (int battery : batteries) {
                totalUsableCapacity += Math.min(mid, battery);
            }

            // Check if we can run n computers for 'mid' minutes
            // We need at least n * mid total battery capacity
            if (totalUsableCapacity >= n * mid) {
                // Can sustain this runtime, try for a longer time
                left = mid;
            } else {
                // Cannot sustain this runtime, try for a shorter time
                right = mid - 1;
            }
        }

        // Return the maximum runtime found
        return left;
    }
}
