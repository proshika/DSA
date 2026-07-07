class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                sb.insert(0, digit);
            }
            n /= 10;
        }
        long x = sb.length() > 0 ? Long.parseLong(sb.toString()) : 0;
        long temp = x;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum * x;
    }
}