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
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        if(k==0 || head==null || head.next==null)
            return head;
        ListNode temp=head;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        ListNode current=head;
        for(int i=0;i<len-k-1;i++){
            current=current.next;
        }
        ListNode newHead=current.next;
        current.next=null;
        temp.next=head;
        return newHead;
    }
}