class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n= piles.length;

        for(int i=0;i<n;i++){
            if(max<piles[i]) max=piles[i];
        }

        int l=1, r=max;
        int minH = max;
        while(l<r){
        
            int mid = l+(r-l)/2;

            long total=0;
            for(int j=0;j<piles.length;j++){

                if(mid>piles[j]) total+=1;
                else total+=Math.ceil((double)piles[j]/(double)mid);
                
            }
            if(total<=h){
                r=mid;
            } else{
                l=mid+1;
            }
          
            System.out.println("Total: "+total+" mid:"+mid);
             System.out.println("l: "+l+" r:"+r);

        }
        return l;
    }
}
