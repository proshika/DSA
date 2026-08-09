class Solution {
    private int[][] memo;
    private int[] suffixSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        // memo[i][M] stores the max stones a player can get starting at index i with parameter M
        memo = new int[n][n + 1];
        suffixSum = new int[n];
        
        // Step 1: Calculate suffix sums from right to left
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return helper(0, 1, n);
    }

    private int helper(int i, int M, int n) {
        if (i >= n) return 0;
        
        // If we can take all the remaining piles, we definitely should
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        // Return cached result if we've already calculated this state
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;
        
        // Try taking x piles, where 1 <= x <= 2 * M
        for (int x = 1; x <= 2 * M; x++) {
            // The stones we get = (total remaining stones) - (what the next player optimally gets)
            int opponentBest = helper(i + x, Math.max(M, x), n);
            int currentTake = suffixSum[i] - opponentBest;
            
            maxStones = Math.max(maxStones, currentTake);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}