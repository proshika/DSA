class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];  
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
       }

        Stack<Character> st = new Stack<>();
        boolean[] inStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            if(inStack[s.charAt(i) - 'a']) continue;
            
            while(!st.isEmpty() && s.charAt(i) < st.peek() && last[st.peek() - 'a'] > i) {
                inStack[st.pop() - 'a'] = false;
            }
            st.push(s.charAt(i));
            inStack[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString(); 
    }
}