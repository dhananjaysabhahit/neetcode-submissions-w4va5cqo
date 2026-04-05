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
        nMap.put(null,null);
        while(t1!=null){
            Node node = new Node(t1.val);
            nMap.put(t1,node);
            t1=t1.next;
        }
        
        t1=head;
        while(t1!=null){
            Node t2= nMap.get(t1);
            t2.next=nMap.get(t1.next);
            t2.random=nMap.get(t1.random);
            t1=t1.next;
        }
        return nMap.get(head);
    }
}
