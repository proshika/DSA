class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int number=n;
        while (number !=0) {
            int digit = number % 10;
            number/=10;
            sum += digit;
            prod *= digit;
        }
        return n%(sum+prod)==0;
    }
}