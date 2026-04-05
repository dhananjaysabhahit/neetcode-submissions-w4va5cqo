/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node,Node> nMap = new HashMap<>();
        Node t1=head;
        Node newHead = new Node(head.val);
        Node t2= newHead;
        nMap.put(head,newHead);
        t1=t1.next;
        while(t1!=null){
            Node node = new Node(t1.val);
            t2.next=node;
            t2=t2.next;
            nMap.put(t1,t2);
            t1=t1.next;
        }
        t2.next=null;
        t2=newHead;
        t1=head;
        while(t1!=null){
            if(t1.random!=null && nMap.containsKey(t1.random))
                t2.random=nMap.get(t1.random);
            
            t1=t1.next;
            t2=t2.next;
        }
        return newHead;
    }
}
