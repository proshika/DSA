class Solution {
    public int maximum69Number (int num) {
        if(num==9999){
            return 9999;
        }
        while(num>0 && num<9999 && num!=9999){
             String s=Integer.toString(num);
             s=s.replaceFirst("6","9");
             return Integer.parseInt(s);
        }
        return num;
    }
}