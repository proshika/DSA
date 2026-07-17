/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy=new ListNode(0,node);
        ListNode curr=node;
        ListNode prev=dummy;

        while(curr!=null){
            if(curr.val==node.val){
                node.val = node.next.val;
                node.next = node.next.next;
            }
            curr=curr.next;
            prev=curr;
        }
    }
}