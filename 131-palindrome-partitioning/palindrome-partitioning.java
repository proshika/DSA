class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        Backtrack(s,result,ans);
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void Backtrack(String s, List<List<String>> result, List<String> ans) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String part = s.substring(0, i + 1);

            if (isPalindrome(part)) {
                ans.add(part);
                Backtrack(s.substring(i + 1), result, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}