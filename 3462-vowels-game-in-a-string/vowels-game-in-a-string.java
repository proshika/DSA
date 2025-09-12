class Solution {
    public boolean doesAliceWin(String s) {
       int vowels=0;
       for(char c:s.toCharArray()){
        if(isvowel(c)) return true;
       }
       return false;
       
    }
    private boolean isvowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}