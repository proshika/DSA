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
    public int numComponents(ListNode head, int[] nums) {
        int count=0;
        ListNode curr=head;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while(curr!=null){
            if(set.contains(curr.val)){
                count++;
                while(curr!=null && set.contains(curr.val)){
                    curr=curr.next;
                }
            }
            if(curr!=null){
                curr=curr.next;
            }
        }
        return count;
    }
}