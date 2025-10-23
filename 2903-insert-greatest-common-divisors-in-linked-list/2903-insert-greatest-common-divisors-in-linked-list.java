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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null && head.next!=null){
            return head;
        }
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            int gcdval=gcd(temp.val,temp.next.val);
            ListNode nn=new ListNode(gcdval);
            nn.next=temp.next;
            temp.next=nn;
            temp=nn.next;
        }
        return head;
    }
    int gcd(int n1,int n2){
        while(n2!=0){
            int temp=n2;
            n2=n1%n2;
            n1=temp;
        }
        return n1;
    }
}