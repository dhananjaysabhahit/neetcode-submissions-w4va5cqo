/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null) return node;

        Map<Node,Node> oldNewMap = new HashMap<>();

        Queue<Node> nodeq = new LinkedList<>();
        nodeq.add(node);

        while(!nodeq.isEmpty()){
            int n = nodeq.size();
            for(int i=0;i<n;i++){
                Node cur = nodeq.poll();
                Node newNode;
                if(!oldNewMap.containsKey(cur)){
                    newNode = new Node(cur.val);
                    oldNewMap.put(cur,newNode);
                } else{
                    newNode = oldNewMap.get(cur);
                }
                if(cur.neighbors !=null && !cur.neighbors.isEmpty()){
                    for(Node ele: cur.neighbors){
                        Node newEle;
                        if(ele!=null && !oldNewMap.containsKey(ele)){
                            nodeq.add(ele);
                            newEle = new Node(ele.val);
                            oldNewMap.put(ele,newEle);
                            
                        } else{
                            newEle = oldNewMap.get(ele);
                        }
                        newNode.neighbors.add(newEle);
                        
                    }
                }
            }
        }
        return oldNewMap.get(node);
    }
}