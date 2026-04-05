class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total=0;
        for(int i=0;i<gas.length;i++){
            total += (gas[i]-cost[i]);
        }
        if(total<0) return -1;
        total=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
            total += (gas[i]-cost[i]);
            if(total<0){
                res=i+1;
                total =0;
            }
        }
        return res;
    }
}

// 1,2,3,4
// 2,2,4,1

// -1,0,-1,3
