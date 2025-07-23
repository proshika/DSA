class Solution {
    String str;
    public int removeSubstring(String pair,int score){
        int totalscore=0;
        Stack<Character> s=new Stack<>();
        char firstChar=pair.charAt(0);
        char secChar=pair.charAt(1);
        for(char ch:str.toCharArray()){
            if(ch==secChar && !s.isEmpty()&& s.peek()==firstChar){
                totalscore+=score;
                s.pop();
            }else{
                s.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0,s.pop());
        }
        str=sb.toString();
        return totalscore;
    }
    public int maximumGain(String s, int x, int y) {
        str=s;
        String firstPair=(x>y)?"ab":"ba";
        String secPair=(firstPair.equals("ab"))?"ba":"ab";
        int score=0;
        score=removeSubstring(firstPair,Math.max(x,y));
        score+=removeSubstring(secPair,Math.min(x,y));
        return score;
    }
}