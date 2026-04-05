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
            remove(node);
            add(node);
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
            remove(cache.get(key)); 
        } 

        Node node = new Node(key,value);
        cache.put(key,node);
        add(node);

        if(cache.size()>capacity){
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        node.next=null;
        node.prev=null;
    }

    void add(Node node){
        node.next=head.next;
        head.next=node;
        node.prev=head;
        node.next.prev=node;
    }
}
