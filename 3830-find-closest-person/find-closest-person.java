class Solution {
    public int findClosest(int x, int y, int z) {
        int sub1=Math.abs(z-x);
        int sub2=Math.abs(z-y);
        if(sub1<sub2){
            return 1;
        }
        else if(sub1>sub2){
            return 2;
        }
        else{
           return 0;
        }
    }
}