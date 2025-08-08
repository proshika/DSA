class Solution {
    private double[][] memo;
    public double soupServings(int n) {
        if(n>=4800){
            return 1.0;
        }
        int scaledn=(n+24)/25;
        memo=new double[scaledn+1][scaledn+1];

        return calculateProbability(scaledn,scaledn);
    }
    private double calculateProbability(int a,int b){
        if(a<=0 && b<=0){
            return 0.5;
        }
        if(a<=0){
            return 1.0;
        }
        if(b<=0){
            return 0.0;
        }
        if(memo[a][b]>0){
            return memo[a][b];
        }
        double prob=0.25*(calculateProbability(a-4,b)+calculateProbability(a-3,b-1)
        +calculateProbability(a-2,b-2)+calculateProbability(a-1,b-3));

        memo[a][b]=prob;
        return prob;
    }
}