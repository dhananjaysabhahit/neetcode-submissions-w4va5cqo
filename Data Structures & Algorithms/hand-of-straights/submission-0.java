class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;

        Map<Integer,Integer> freq = new HashMap<>();
        Arrays.sort(hand);

        for(int i=0;i<n;i++){
            freq.put(hand[i],freq.getOrDefault(hand[i],0)+1);
        }
        
        int cnt=0; 
        for(int i=0;i<n;i++){
            int cur=hand[i];
            int curCnt=0;
            while(freq.containsKey(cur) && freq.get(cur)>0){
                freq.put(cur,freq.get(cur)-1);
                cur++;
                curCnt++;
                cnt++;
                if(curCnt%groupSize==0){
                    break;
                }
            }
            if(curCnt%groupSize!=0) return false;
            if(cnt==n) return true;
        }
        
        return false;
    }
}
