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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        // Step 1: Move to the k-th node from the start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode kthFromStart = first;

        // Step 2: Use two pointers to find k-th node from the end
        ListNode second = head;
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }
        ListNode kthFromEnd = second;

        // Step 3: Swap their values
        int val = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = val;

        return head;
    }
}