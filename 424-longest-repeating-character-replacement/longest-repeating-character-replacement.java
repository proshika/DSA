class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,maxfreq=0,maxlen=0;
        int[] count=new int[26];

        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,count[s.charAt(right)-'A']);

            while(right-left+1-maxfreq>k){
                count[s.charAt(left++)-'A']--;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}