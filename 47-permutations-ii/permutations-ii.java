class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        boolean[] used=new boolean[n];
        backtrack(new ArrayList<>(),nums,used);
        return result;
    }
    public void backtrack(List<Integer> ans,int[] nums,boolean[] used){
        if(ans.size()==nums.length){
            result.add(new ArrayList<>(ans));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            ans.add(nums[i]);
            backtrack(ans,nums,used);
            used[i]=false;
            ans.remove(ans.size()-1);
        }
    }
}