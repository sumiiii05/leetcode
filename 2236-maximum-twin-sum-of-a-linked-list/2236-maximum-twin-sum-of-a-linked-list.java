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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int maxval=0;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode nn,prev=null;
        while(slow!=null){
            nn=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nn;
        }
        while(prev!=null){
            maxval=Math.max(maxval,head.val+prev.val);
            prev=prev.next;
            head=head.next;
        }
        return maxval;
    }
}