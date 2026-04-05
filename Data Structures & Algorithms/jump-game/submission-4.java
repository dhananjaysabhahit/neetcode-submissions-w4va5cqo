class Solution {
    public boolean canJump(int[] nums) {

        int n =nums.length;
        return dfs(nums,0);
    }

    boolean dfs(int[] nums, int jmp){
        
        if(jmp>=nums.length-1) return true;
        if(nums[jmp]==0) return false;
        int temp=jmp+nums[jmp];
        boolean res = false;
        for(int i=jmp+1;i<=temp && i<nums.length;i++){
            res = res || dfs(nums,i);
        }
        return res;
    }
}
