class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                for(int dir:new int[]{1,-1}){
                    int[] arr=Arrays.copyOf(nums,n);
                    int curr=i,d=dir;
                    while(curr>=0 && curr<n){
                        if(arr[curr]==0){
                            curr+=d;
                        }else{
                            arr[curr]--;
                            d=-d;
                            curr+=d;
                        }
                    }
                    boolean allzero=true;
                    for(int val:arr) if(val!=0) allzero=false;
                    if(allzero) count++;
                }
            }
        }
        return count;
    }
}