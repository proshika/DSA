class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        int n=nums.length;
        int gcdarr=nums[0];
        for(int num:nums){
            if(num==1){
                count++;
            }
            gcdarr=gcd(gcdarr,num);
        }
        if(count>0){
            return n-count;
        } 
        if(gcdarr!=1){
            return -1;
        }
        int size=n;
        for(int i=0;i<nums.length;i++){
            int gcd=nums[i];
            for(int j=i+1;j<nums.length;j++){
                gcd=gcd(gcd,nums[j]);
                if(gcd==1){
                    size=Math.min(size,j-i+1);
                    break;
                }
            }
        }
        return size-1+n-1;
    }
    private int gcd(int a, int b) {
       if(b==0){
        return a;
       }
       return gcd(b,a%b);
   }
}