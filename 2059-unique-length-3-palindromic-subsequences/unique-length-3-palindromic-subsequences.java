class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(first[c]==-1){
                first[c]=i;
            }
            last[c]=i;
        }
        int ans=0;
        for(int c=0;c<26;c++){
            if(first[c]!=-1 && first[c]<last[c]){
                boolean[] seen=new boolean[26];
                for(int k=first[c]+1;k<last[c];k++){
                    seen[s.charAt(k)-'a']=true;
                }
                for(int m=0;m<26;m++){
                    if(seen[m]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}