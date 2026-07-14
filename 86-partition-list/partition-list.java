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
    public ListNode partition(ListNode head, int x) {
        ListNode lesshead=new ListNode(0);
        ListNode greaterhead=new ListNode(0);  
        ListNode less=lesshead;
        ListNode greater=greaterhead;
        while(head!=null){
            if(head.val<x){
               less.next=head;
               less=less.next;
            }
            else{
                greater.next=head;
                greater=greater.next;
            }
            head=head.next;
        }
        less.next=greaterhead.next;
        greater.next=null;
        return lesshead.next;
    }
}