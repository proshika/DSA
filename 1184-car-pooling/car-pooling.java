class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline = new int[1001]; // Locations from 0 to 1000

        for (int[] trip : trips) {
            timeline[trip[1]] += trip[0];  // Pick up
            timeline[trip[2]] -= trip[0];  // Drop off
        }

        int currentPassengers = 0;
        for (int passengers : timeline) {
            currentPassengers += passengers;
            if (currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }
}