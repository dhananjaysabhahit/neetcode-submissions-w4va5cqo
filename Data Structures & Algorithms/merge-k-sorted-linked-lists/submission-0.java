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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0){
            return null;
        }
        if(n==1){
            return lists[0];
        }
        for(int i=1;i<n;i++){
            lists[i]=mergeTwoLists(lists[i],lists[i-1]);
        }
        return lists[n-1];
    }

    public ListNode mergeTwoLists(ListNode h1, ListNode h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        ListNode t1=h1,t2=h2;
        ListNode node = new ListNode(-1);
        ListNode dummy = node;
        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                node.next=t1;
                t1=t1.next;
            } else {
                node.next=t2;
                t2=t2.next;
            }
            node=node.next;
        }
        if(t1!=null){
            node.next=t1;
        } else if(t2!=null){
            node.next=t2;
        }
        ListNode res= dummy.next;
        dummy.next=null;
        return res;
    }
}
