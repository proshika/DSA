class Solution {
    public int maxOperations(String s) {
        int ones = 0, ops = 0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                ones++;
            }else{
                if(i>0 && s.charAt(i-1)=='1'){
                    ops+=ones;
                }
            }
        }
        return ops;
    }
}