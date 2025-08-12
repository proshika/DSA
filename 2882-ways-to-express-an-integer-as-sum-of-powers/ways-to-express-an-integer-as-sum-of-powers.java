class Solution {
    private int MOD=1000000007;
    public int numberOfWays(int n, int x) {
        Integer[][] memo=new Integer[n+1][n+1];
        return helper(n,1,x,memo);
    }
    private int calcPow(int a,int power){
       long result=1;
       for(int i=0;i<power;i++){
        result=result*a;
       }
       return (int)result;
    }
    private int helper(int remaining,int current,int power,Integer[][] memo){
        if(remaining<0){
            return 0;
        }
        if(remaining==0){
            return 1;
        }
        int currpower=calcPow(current,power);
        if(currpower>remaining){
            return 0;
        }
        if(memo[remaining][current]!=null){
            return memo[remaining][current];
        }
        int pick=helper(remaining-currpower,current+1,power,memo)%MOD;
        int notpick=helper(remaining,current+1,power,memo)%MOD;
          memo[remaining][current]=(pick+notpick)%MOD;
        return memo[remaining][current];
    }
}