class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count=0;
        int prevend = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            if(start<prevend){
                count++;
                prevend = Math.min(prevend,intervals[i][1]);
            } else{
                prevend = intervals[i][1];
            }
        }
        
        return count;
    }
}
