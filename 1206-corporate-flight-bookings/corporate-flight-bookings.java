class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefix = new int[n];
        for(int[] booking:bookings){
        int left = booking[0];
        int right = booking[1];
        int seat = booking[2];
        prefix[left - 1] += seat;
        if (right < n) {
            prefix[right] -= seat;
        }
    }
        for (int i = 1; i < n ; i++) {
            prefix[i] += prefix[i - 1];
        }
        return prefix;
    }
}