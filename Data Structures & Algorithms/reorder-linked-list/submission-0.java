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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        
        
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode t2 = slow.next;
        
        ListNode prev= slow.next=null;
        while(t2!=null){
            ListNode next=t2.next;
            t2.next=prev;
            prev=t2;
            t2=next;
        }
        t2=prev;
        ListNode dummy=new ListNode(-1);
        ListNode t3= dummy;
        ListNode t1=head; 
        while(t1!=null && t2!=null){
            t3.next=t1;
            ListNode  temp1 = t1.next;
            ListNode temp2=t2.next;
            t3.next.next=t2;
            t3=t3.next.next;
            t1=temp1;
            t2=temp2;
        }
        if(t1!=null){
            t3.next=t1;
        } else if(t2!=null){
            t3.next=t2;
        }
    }
}
