class Solution {
    int n=0; 
    public boolean canJump(int[] nums) {
        n =nums.length;
        Map<Integer,Boolean> memo= new HashMap<>();
        return dfs(nums,0,memo);
    }

    boolean dfs(int[] nums, int jmp, Map<Integer,Boolean> memo){
        if(memo.containsKey(jmp)) return memo.get(jmp);
        if(jmp>=nums.length-1) return true;
        if(nums[jmp]==0) return false;
        int temp=jmp+nums[jmp];
        
        for(int i=jmp+1;i<=temp && i<nums.length;i++){
            if(dfs(nums,i,memo)) {
                memo.put(i,true);
                return true;
            }
        }
        memo.put(jmp,false);
        return false;
    }
}
