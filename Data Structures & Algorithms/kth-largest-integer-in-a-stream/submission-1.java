class KthLargest {
    //approach 1
    PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
    int k;

    // approach 2
    List<Integer> numsL;
    
    public KthLargest(int k, int[] nums) {
        //approach 1
        this.k=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }

        // apprach 2
        this.numsL = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        numsL.sort(Comparator.naturalOrder());
        
    }
    
    public int add(int val) {
        // approach 1
        pq.add(val);
        if(pq.size()>k)
            pq.poll();
        // return pq.peek();

        //approach 2
        int inPos = getInsertPosition(val);
        numsL.add(inPos,val);
        System.out.println(numsL.toString());
        return numsL.get(numsL.size()-k);
    }

    int getInsertPosition(int val){
        int l=0,h=numsL.size()-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(numsL.get(mid)==val)
                return mid;
            else if(val<numsL.get(mid))
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}
