class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int[][] querIdx =IntStream.range(0,queries.length)
                                .mapToObj(i->new int[]{queries[i],i})
                                .toArray(int[][]::new);
        Arrays.sort(querIdx,(a,b)->a[0]-b[0]);

        for(int j=0;j<queries.length;j++){
            System.out.println("queries : "+queries[j]);
            for(int i=0;i<intervals.length;i++){
                System.out.println("interval: "+intervals[i][0]+","+intervals[i][1]);
                if(queries[j]>=intervals[i][0] && queries[j]<=intervals[i][1]){
                    int len = intervals[i][1]-intervals[i][0]+1;
                    pq.add(new int[]{len,i});
                } else if(queries[j]<intervals[i][0]){
                    break;
                }
            }
            if(!pq.isEmpty()){
                queries[j]= pq.poll()[0];
                pq.clear();
            } else{
                queries[j]= -1;
            }
        }
        return queries;
    }
}
