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
    public ListNode reverseList(ListNode head) {
        //approach 1
        // if(head==null || head.next==null){
        //     return head;
        // }
        // ListNode temp=head;
        // Stack<Integer> stack =new Stack(); 
        // while(temp!=null){
        //     stack.push(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     int num = stack.pop();
        //     temp.val=num;
        //     temp=temp.next;
        // }
        // return head;

        // approach 2
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp= head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}
