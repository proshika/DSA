class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                ans= entry.getKey();
            }
        }
        return ans;
        */
        int l=0,r=nums.length-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if(mid%2==1) mid--;
                if(nums[mid]==nums[mid+1]){
                    l=mid+2;
                }
                else{
                    r=mid;
                }
            }            
        return nums[l];
    }
}