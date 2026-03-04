class Solution {
    public char findKthBit(int n, int k) {
        String[] s = new String[n + 1];
        s[1] = "0";
        for (int i = 2; i <= n; i++) {
            String prev = s[i - 1];
            String inverted = invert(prev); // implement this
            String reversed = new StringBuilder(inverted).reverse().toString();
            s[i] = prev + "1" + reversed;
        }
        return s[n].charAt(k - 1);
    }
    String invert(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        // Flip '0' to '1' and '1' to '0'
        sb.append(c == '0' ? '1' : '0');
    }
    return sb.toString();
}
}