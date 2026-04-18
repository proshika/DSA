class Solution {
    public int mirrorDistance(int n) {
        int rev=reverse(n);
        int dis=Math.abs(n-rev);
        return dis;
    }
    private int reverse(int num){
        int reverse=0;
        for(int i=0;i<num;i++){
            while(num>0){
                int digit=num%10;
                reverse=reverse*10+digit;
                num=num/10;
            }
        }
        return reverse;
    }
}