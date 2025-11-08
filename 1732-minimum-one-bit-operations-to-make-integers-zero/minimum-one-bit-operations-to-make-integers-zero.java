class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int k = 0;
        // Find highest set bit
        while ((1 << (k + 1)) <= n) k++;
        // Flip the highest bit and recurse
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ (1 << k));
    }
    private String toBinary(int n){
        if(n==0) return "0";
        StringBuilder sb=new StringBuilder();
        while(n>0){
           n=n%2;
           sb.append(n);
           n=n/2;
        }
        return sb.reverse().toString();
    }
}