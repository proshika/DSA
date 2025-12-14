class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int n = corridor.length();
        int seatCount = 0;
        // Count total seats
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') seatCount++;
        }
        // If seats are not even or less than 2, no way to divide
        if (seatCount < 2 || seatCount % 2 != 0) return 0;

        long ways = 1;
        int currSeats = 0;
        int i = 0;
        while (i < n) {
            // Find the first seat to start a section
            if (corridor.charAt(i) == 'S') currSeats++;
            if (currSeats == 2) {
                int plants = 0;
                int j = i + 1;
                // Count plants until next seat (start of next section)
                while (j < n && corridor.charAt(j) != 'S') {
                    plants++;
                    j++;
                }
                // If not at the end, multiply ways by (plants + 1)
                if (j < n) ways = (ways * (plants + 1)) % MOD;
                currSeats = 0;
                i = j - 1; // Set i to the last plant before next seat
            }
            i++;
        }
        return (int) ways;
    }
}