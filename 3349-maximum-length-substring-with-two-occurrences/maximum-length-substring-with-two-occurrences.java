class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int left=0,length=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>2){
                char ch1=s.charAt(left);
                hm.put(ch1,hm.get(ch1)-1);
                left++;
            }
            length=Math.max(length,right-left+1);
        }
        return length;
    }
}