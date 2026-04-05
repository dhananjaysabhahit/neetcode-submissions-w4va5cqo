class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur = res.get(res.size()-1);
            if(cur[1]<=intervals[i][0]){
                res.add(intervals[i]);
            } else{
                if(cur[1]>=intervals[i][1]){
                    res.remove(cur);
                    res.add(intervals[i]);
                }
            }
            System.out.println(res);
        }
        
        return intervals.length - res.size();
    }
}
