class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int last[]=new int[32];
        for(int i=n-1;i>=0;i--){
            for(int bit=0;bit<32;bit++){
                if(((nums[i]) &(1<<bit))!=0){
                    last[bit]=i;
                }
            }
            int maxidx=i;
            for(int bit=0;bit<32;bit++){
                maxidx=Math.max(maxidx,last[bit]);
            }
            ans[i]=maxidx-i+1;
        }
        return ans;
    }
}