import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] maxValueSoFar = new int[n];
        maxValueSoFar[0] = events[0][2];

        // Build prefix max array for fast lookups
        for (int i = 1; i < n; i++) {
            maxValueSoFar[i] = Math.max(maxValueSoFar[i - 1], events[i][2]);
        }

        int answer = 0;
        // For every event, try to pair with the best previous non-overlapping event
        for (int i = 0; i < n; i++) {
            // Binary search for the latest event that ends before this starts
            int lo = 0, hi = i - 1, idx = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (events[mid][1] < events[i][0]) {
                    idx = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            int pairSum = events[i][2];
            if (idx != -1) {
                pairSum += maxValueSoFar[idx];
            }
            answer = Math.max(answer, pairSum);
        }
        return answer;
    }
}