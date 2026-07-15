class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd = 0;
        int sumeven = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                sumeven += i;
            }
            sumodd += i;
        }
        return gcd(sumeven,sumodd);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}