class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n==1) return stones[0];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(!pq.isEmpty()){
            if(pq.size()==1) break;
            int s1=pq.poll();
            int s2=pq.poll();
            if(s1!=s2) pq.add(Math.abs(s1-s2));
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
