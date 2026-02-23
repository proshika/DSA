class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        Backtrack(n,ans,"",0,0);
        return ans;
    }
    private void Backtrack(int n,List<String> ans,String s,int count1,int count2){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
       if (count1 < n) {
            Backtrack(n, ans, s + "(", count1 + 1, count2);
       }
        if(count2<count1){
            Backtrack(n, ans, s + ")", count1, count2+1);
        }
    }
}