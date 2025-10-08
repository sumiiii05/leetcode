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
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        //reverse the Linkedlist
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nn=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nn;
        }

        //finding greater value
        ListNode start=prev.next;
        ListNode conn=prev;
        while(start != null){
            if(start.val>=conn.val){
                conn.next=start;
                conn=start;
            }
            start=start.next;
        }
        conn.next=null;

        //reverse Linkedlist again
        curr=prev;
        prev=null;
        while(curr!=null){
            ListNode nn=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nn;
        }
        return prev;
    }
}