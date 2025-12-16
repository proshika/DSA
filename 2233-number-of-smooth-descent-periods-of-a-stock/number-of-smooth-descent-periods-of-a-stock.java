class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=1;
        int length=1;
        int n=prices.length;
        for(int i=1;i<prices.length;i++){
            if(prices[i]==prices[i-1]-1){
                length++;
            }else{
                length=1;
            }
            ans+=length;
        }
        return ans;
    }
}