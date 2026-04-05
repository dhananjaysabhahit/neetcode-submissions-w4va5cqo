/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals.size();
        intervals.sort((a,b)->a.start-b.start);
        int count=0;
        int prevend = intervals.get(0).end;
        List<List<Interval>> res = new ArrayList<>();
        res.add(new ArrayList<Interval>(List.of(intervals.get(0))));
        for(int i=1;i<intervals.size();i++){
            
                int s =res.size();
                int j=0;
                while(j<s){
                    int ins = res.get(j).size();
                    if(res.get(j).get(ins-1).end<=intervals.get(i).start){
                        res.get(j).add(intervals.get(i));
                        System.out.println(intervals.get(i).start+","+intervals.get(i).end);
                        break;
                    }
                    j++;
                }
                if(j==s){
                    res.add(new ArrayList<Interval>(List.of(intervals.get(i))));
                    System.out.println(intervals.get(i).start+","+intervals.get(i).end);
                }
            

        }
        
        return res.size();
    }
}
