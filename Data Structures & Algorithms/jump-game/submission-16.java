class Solution {
    int n=0; 
    public boolean canJump(int[] nums) {
        n =nums.length;
        Map<Integer,Boolean> memo= new HashMap<>();
        return dfs(nums,0,memo);
    }

    boolean dfs(int[] nums, int jmp, Map<Integer,Boolean> memo){
        // if(memo.containsKey(jmp)) return memo.get(jmp);
        if(jmp==nums.length-1) return true;
        if(nums[jmp]==0) return false;
        
        int end=Math.min(jmp+nums[jmp],nums.length-1);

        for(int i=jmp+1;i<=end;i++){
            if(memo.containsKey(i)){
                if(memo.get(i)){
                    memo.put(jmp,true);
                    return true;
                }
            } else{
                if(dfs(nums,i,memo)){
                    memo.put(i,true);
                    memo.put(jmp,true);
                    return true;
                }
            }
        }

        memo.put(jmp,false);
        return false;
    }
}
