class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0;
        int beg=0;
        String Tofind=word;
        while(true){
            int idx=sequence.substring(beg).indexOf(Tofind);
            if(idx==-1){
                return count;
            }
            else{
                count++;
                Tofind+=word;
                beg=idx;
            }
        }
    }
}