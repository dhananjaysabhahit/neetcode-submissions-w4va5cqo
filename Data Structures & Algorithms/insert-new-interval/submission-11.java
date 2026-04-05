class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n= intervals.length;
        if(n==0)
            return new int[][]{newInterval};
        
        int idx = binarySearch(intervals,newInterval[0]);
        
        
        List<int[]> res= new ArrayList<>();

        for(int i=0;i<idx;i++) 
            res.add(intervals[i]);

        res.add(newInterval);
        for(int i=idx;i<n;i++){
            res.add(intervals[i]);
        }
    
        
        List<int[]> merged = new ArrayList<>();
        for(int[] interval: res){
            
            if(merged.isEmpty()||merged.get(merged.size()-1)[1]<interval[0]){
                merged.add(interval);
            } else{

                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
    int binarySearch(int[][] intervals, int startind){
        int n=intervals.length;
        int l=0,h=n-1;
        while(l<=h){
            int m= l+(h-l)/2;
            if(intervals[m][0]>=startind){
                h=m-1;
            } else if(intervals[m][0]<startind){
                l=m+1;
            }
        }
        return l;
    }
}
