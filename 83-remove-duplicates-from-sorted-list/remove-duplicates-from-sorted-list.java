/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (seen.contains(curr.val)) {
                prev.next = curr.next; // skip duplicate
            } else {
                seen.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}