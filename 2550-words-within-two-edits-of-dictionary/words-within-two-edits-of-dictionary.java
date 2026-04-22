class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int len = queries[0].length(); // To avoid index out of bounds
        for(String query:queries){
            for(String word:dictionary){
                int count=0;
                for(int i=0;i<len;i++){
                    if(query.charAt(i)!=word.charAt(i)){
                        count++;
                    }
                }
                if(count<=2){
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }
}