class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int lh=0;
        int rh=height.length-1;

        while(lh<rh){
                int ht=Math.min(height[lh],height[rh]);
                int width=rh-lh;
                int currwater=ht*width;
                max=Math.max(max,currwater);
                if(height[lh]<height[rh]){
                    lh++;
                }
                else{
                    rh--;
                }
        }
        return max;
    }
    public void main(String args[]){
       int height[]={1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(height));

    }
}