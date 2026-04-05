class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Map.Entry,AbstractMap.SimpleEntry<>()
        // Pair<>, getKey, getValue
        // int[]
        //Object[] can store all datatypes
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        // int n= nums.length,resS = n-k+1;

        // int[] res = new int[resS];
        // for(int i=0;i<k;i++){
        //     pq.offer(new int[]{i,nums[i]});
        // }
        // int rI =0, ind;
        // res[rI] = pq.peek()[1];
        // for(int i=k;i<n;i++){
        //     pq.offer(new int[]{i,nums[i]});
        //     while(pq.peek()[0]<=i-k)
        //         pq.poll();
        //     res[++rI]=pq.peek()[1]; 
        // }
        // return res;

        // approach 2
        Deque<Integer> dq = new ArrayDeque<>();
        int l=0,r=0;
        int n =  nums.length;
        int rI=0;
        int[] res = new int[n-k+1];
        while (r<n){
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[r])
                dq.removeLast();
            dq.addLast(r);

            if(l>dq.getFirst()){
                dq.removeFirst();
            }
            if((r+1)>=k){
                res[rI++] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
