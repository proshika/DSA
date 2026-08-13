class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        
        int n = list.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                int indexToUpdate = stack.pop();
                ans[indexToUpdate] = list.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}