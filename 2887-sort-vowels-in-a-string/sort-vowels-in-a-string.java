class Solution {
    public String sortVowels(String s) {
        List<Integer> vowelIndices=new ArrayList<>();
        List<Character> vowels=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isvowel(ch)){
                vowelIndices.add(i);
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<vowelIndices.size();i++){
            str.setCharAt(vowelIndices.get(i),vowels.get(i));
        }
        return str.toString();
    }
    private boolean isvowel(char ch){
        ch=Character.toLowerCase(ch);
        return ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u';
    }
}