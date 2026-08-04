class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),n,k,1);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> ans,int n,int k,int idx){
        if(ans.size()==k){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i=idx;i<=n;i++){
            ans.add(i);
            backtrack(result,ans,n,k,i+1);
            ans.remove(ans.size()-1);
        }
    }
}