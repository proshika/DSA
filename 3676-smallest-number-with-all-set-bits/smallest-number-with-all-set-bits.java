class Solution {
    public int smallestNumber(int n) {
       while(true){
       if(!decimalToBinary(n).contains("0")){
        return n;
       }
       n++;
       }
    }
    public String decimalToBinary(int n) {
    if (n == 0) return "0";
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
        sb.append(n % 2);
        n /= 2;
    }
    return sb.reverse().toString();
}
}