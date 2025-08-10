class Solution {
    public boolean reorderedPowerOf2(int n) {
        String sing=sortedDigits(n);
        for(int i=1;i<1000000000;i*=2){
            if(sing.equals(sortedDigits(i))){
                return true;
            }
        }
        return false;
    }
    String sortedDigits(int n){
        char[] arr=String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}