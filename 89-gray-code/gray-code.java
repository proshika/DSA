class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);

        if(n==0) return ans;
        ans.add(1);

        int curr=1;
        for(int i=2;i<=n;i++){
            curr*=2;
            for(int j=ans.size()-1;j>=0;j--){
                ans.add(curr+ans.get(j));
            }
        }
        return ans;
    }
}