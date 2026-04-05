class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n= piles.length;

        for(int i=0;i<n;i++){
            if(max<piles[i]) max=piles[i];
        }

        int l=1, r=max;
        int minH = max;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canEat(piles,mid,h)){
                minH=mid;
                r=mid-1;
            } else{
                l=mid+1;
            }
        }
        return minH;
    }
    boolean canEat(int[] piles,int mid,int h){
        int total =0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/mid);
        }
        return total<=h;
    }
}
