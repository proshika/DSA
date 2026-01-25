class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int len=0;
        int n = nums.length;
        int prefix=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            prefix+=nums[i];
            if(map.containsKey(prefix)){
                len=Math.max(len,i-map.get(prefix));
            }else{
               map.put(prefix,i);
            }
        }
        return len;
    }
}