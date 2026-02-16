class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=p.length();
        int ns=s.length();
        if (s.length() < p.length()) return ans;
        int[] sCount=new int[26];
        int[] pCount=new int[26];

        for(char ch:p.toCharArray()){
            pCount[ch-'a']++;
        }
        for(char ch:s.substring(0,n).toCharArray()){
            sCount[ch-'a']++;
        }
        if(Arrays.equals(pCount,sCount)){
            ans.add(0);
        }
        for(int i=1;i<ns-n+1;i++){
            sCount[s.charAt(i-1)-'a']--;
            sCount[s.charAt(i+n-1)-'a']++;
            if(Arrays.equals(pCount,sCount)){
                ans.add(i);
            }
        }
        return ans;
    }
}