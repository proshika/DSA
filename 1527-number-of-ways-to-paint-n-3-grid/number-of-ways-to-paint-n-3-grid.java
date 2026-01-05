class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long typeA = 6; // ABA patterns
        long typeB = 6; // ABC patterns

        for (int i = 2; i <= n; i++) {
            long newTypeA = (typeA * 3 + typeB * 2) % MOD;
            long newTypeB = (typeA * 2 + typeB * 2) % MOD;
            typeA = newTypeA;
            typeB = newTypeB;
        }
        return (int)((typeA + typeB) % MOD);
    }
}