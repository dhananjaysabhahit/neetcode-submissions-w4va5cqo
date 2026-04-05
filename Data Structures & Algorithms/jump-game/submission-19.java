class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal=n-1;
        for(int i=n-2;i>=0;i--){
           int end=nums[i]+i;
           if(end>=goal){
            goal=i;
           }
        }
        return goal==0;
    }
}
