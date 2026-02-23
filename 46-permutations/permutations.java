class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Backtrack(nums,new ArrayList<>(),result);
        return result;
    }
    private void Backtrack(int[] nums,List<Integer> ans,List<List<Integer>> result) {
        int n=nums.length;
        if(ans.size()==n){
            result.add(new ArrayList<>(ans));
            return;
        }
       
        for(int num:nums){
            if(ans.contains(num)){
                continue;
            }
            ans.add(num);
            Backtrack(nums,ans,result);
            ans.remove(ans.size()-1);
        }
    }
}