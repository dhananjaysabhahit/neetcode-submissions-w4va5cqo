class Solution {
    public int maxProfit(int[] prices) {
        // approach 1 suffix/ prefix array
        // int n = prices.length;
        // int[] suf = new int[n];
        // int curSuf=Integer.MIN_VALUE;
        // for(int i=n-1;i>=0;i--){
        //     if(prices[i]>curSuf){        
        //         curSuf = prices[i];
        //     }
        //     suf[i]=curSuf;
        //     // System.out.print(suf[i]+",");
        // }
        // int curPref = Integer.MAX_VALUE;
        // for(int i=0;i< n;i++){
        //     if(prices[i]<curPref){        
        //         curPref = prices[i];
        //     }
        //     suf[i]-=curPref;
        //     System.out.print(suf[i]+",");
        // }
        // int max=0;
        // for(int i=0;i<n;i++){
        //     max=Math.max(max,suf[i]);
        //     // System.out.print(max+",");
        // }
        // return max;

        // approach 2 - 2 pointers
        if(prices.length<=1){
            return 0;
        }
        int left=0, right=1;
        int n = prices.length;
        int max=0;
        while(left<right && right < n){
            if(prices[right]>prices[left]){
                max= Math.max(max,prices[right]-prices[left]);
            } else {
                left=right;
            }
            right++;
        }
        return max;
    }
}
