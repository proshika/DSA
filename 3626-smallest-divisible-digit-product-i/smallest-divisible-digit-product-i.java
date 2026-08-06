class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        while(true){
            if(getdigit(i)%t==0){
                return i;
            }
            i++;
        }
    }
    private int getdigit(int num){
        int prod=1;
        while(num>0){
            prod*=(num%10);
            num=num/10;
        }
        return prod;
    }
}