class Solution {
    public String largestGoodInteger(String num) {
        String largest="";
        for(int i=0;i<num.length()-2;i++){
            if (num.charAt(i) == num.charAt(i+1) && num.charAt
           (i+1) == num.charAt(i+2)) {
            String curr = num.substring(i, i+3);
            if (largest == null || curr.compareTo(largest) > 0) {
                largest = curr;
            }
          }
        }
        return largest;
    }
}