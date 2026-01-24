class Solution {
    private boolean isSameFreq(int freq1[] ,int freq2[]){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
           
        int windowsize=s1.length();   
        for(int i=0;i<s2.length();i++){
            int windowidx=0,idx=i;
            int winfreq[]=new int[26];
            while(idx<s2.length() && windowidx<windowsize){
                winfreq[s2.charAt(idx)-'a']++;
                windowidx++;
                idx++;
            }

            if(isSameFreq(winfreq,freq)){
                return true;
            }
        }
        return false;
    }
}
