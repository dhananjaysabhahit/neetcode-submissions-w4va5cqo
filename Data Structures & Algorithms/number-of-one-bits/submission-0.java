class Solution {
    public int hammingWeight(int n) {
        int mask=1;
        int cnt=0;
        for(int i=0;i<32;i++){
            if((n & mask)==mask){
                cnt++;
            }
            mask=mask<<1;
        }
        return cnt;
    }
}
