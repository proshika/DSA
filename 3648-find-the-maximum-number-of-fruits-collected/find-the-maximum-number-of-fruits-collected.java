class Solution {
    int n;
    int fruits[][];
    int dp1[][];
    int dp2[][];

    int solveBottomleft(int i,int j){
        if(i==n-1 && j==n-1) return 0;
        if(j>=i) return 0;
        if(dp1[i][j]!=-1) return dp1[i][j];

        int maxfruit=0;
        int collectedfruit=fruits[i][j];
        if(i-1>=0) maxfruit=Math.max(maxfruit,collectedfruit+solveBottomleft(i-1,j+1));
        if(j+1<n) maxfruit=Math.max(maxfruit,collectedfruit+solveBottomleft(i,j+1));
        if(i+1<n) maxfruit=Math.max(maxfruit,collectedfruit+solveBottomleft(i+1,j+1));
        return dp1[i][j]=maxfruit;
    }
    private int solveTopright(int i,int j){
        if(i==n-1 && j==n-1) return 0;
        if(i>=j) return 0;
        if(dp2[i][j]!=-1) return dp2[i][j];

        int maxfruit=0;
        int collectedfruit=fruits[i][j];
        if(j-1>=0) maxfruit=Math.max(maxfruit,collectedfruit+solveTopright(i+1,j-1));
        if(i+1<n) maxfruit=Math.max(maxfruit,collectedfruit+solveTopright(i+1,j));
        if(j+1<n) maxfruit=Math.max(maxfruit,collectedfruit+solveTopright(i+1,j+1));
        return dp2[i][j]=maxfruit;
    }

    public int maxCollectedFruits(int[][] fruits) {
        this.n=fruits.length;
        this.fruits=fruits;
        this.dp1=new int[n][n];
        this.dp2=new int[n][n];

        for(int[] row:dp1)  Arrays.fill(row,-1);

        for(int[] row:dp2)  Arrays.fill(row,-1);

        int totalfruits=0;
        for(int i=0;i<n;i++){
            totalfruits+=fruits[i][i];
        }

        totalfruits+=solveBottomleft(n-1,0);
        totalfruits+=solveTopright(0,n-1);
        return totalfruits;
    }
}