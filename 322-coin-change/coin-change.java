class Solution {
    public int coinChange(int coins[],int amount) {
        if(amount==0){
            return 0;
        }
        int[] minDp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            minDp[i]=Integer.MAX_VALUE;

            for(int coin:coins){
                if(coin<=i && minDp[i-coin]!=Integer.MAX_VALUE){
                    minDp[i]=Math.min(minDp[i],minDp[i-coin]+1);
                }
            }
        }
        if(minDp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return minDp[amount];
    }
}