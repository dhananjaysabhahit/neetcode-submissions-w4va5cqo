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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t1=head;
        int size=0;
        ListNode node=new ListNode(-1);
        node.next=head;
        while(t1!=null){
            size++;
            t1=t1.next;
        }
        int nFF = size-n;
        if(nFF==0){
            return head.next;
        }
        t1=head;
        int cnt=0;
        ListNode prev=null;
        while(t1!=null){
            cnt++;
            if(cnt==nFF+1){
                ListNode t=t1.next;
                prev.next=t;
                t1.next=null;
                break;
            }
            prev=t1;
            t1=t1.next;
        }
        return head;
    }
}
