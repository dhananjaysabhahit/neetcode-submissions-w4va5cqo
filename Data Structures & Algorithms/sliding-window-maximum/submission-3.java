class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        int n= nums.length,resS = n-k+1;

        int[] res = new int[resS];
        for(int i=0;i<k;i++){
            pq.offer(new AbstractMap.SimpleEntry<>(i,nums[i]));
        }
        int rI =0, ind;
        res[rI] = pq.peek().getValue();
        for(int i=k;i<n;i++){
            pq.offer(new AbstractMap.SimpleEntry<>(i,nums[i]));
            while(pq.peek().getKey()<=i-k)
                pq.poll();
            res[++rI]=pq.peek().getValue(); 
        }
        return res;
    }
}
