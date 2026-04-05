class Node:
    def __init__(self,key,val):
        self.key, self.val = key,val
        self.prev = self.next=None
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity;
        self.cache ={}

        self.head,self.tail=Node(-1,-1), Node(-1,-1)
        self.head.next, self.tail.prev = self.tail, self.head

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.add(node)
            return node.val
        return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        newnode = Node(key,value)
        self.cache[key]=newnode
        self.add(newnode)
        if len(self.cache)>self.capacity:
            self.cache.pop(self.tail.prev.key)
            self.remove(self.tail.prev)
            


    def remove(self,node):
        node.prev.next,node.next.prev = node.next,node.prev
        node.next,node.prev=None,None
        
    def add(self,node):
        node.next,node.next.prev=self.head.next,node
        node.prev,self.head.next=self.head,node
        
