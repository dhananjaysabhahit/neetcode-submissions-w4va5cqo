class Node{
    int val;
    int key;
    Node next;
    Node prev;

    public Node (int key,int val){
        this.next=null;
        this.prev=null;
        this.key=key;
        this.val=val;
    }
}

class LRUCache {
    int capacity=0;
    Map<Integer,Node> cache;
    Node head=null,tail=null;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        Node node =null;
        if(cache.containsKey(key)){
            node=cache.get(key);
            removeNode(node); 
        } else{
            if(cache.size()>=capacity)
                removeNode(tail.prev);
        }
        node = new Node(key,value);
        addNode(node);
    }

    void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        node.next=null;node.prev=null;
        cache.remove(node.key);
    }

    void addNode(Node node){
        node.next=head.next;
        head.next=node;
        node.prev=head;
        node.next.prev=node;
        cache.put(node.key,node);
    }
}
