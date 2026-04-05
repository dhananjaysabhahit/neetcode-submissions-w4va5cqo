class Solution {
    int min=Integer.MAX_VALUE;
    int n=0; 
    public int jump(int[] nums) {
        n=nums.length;
        Map<Integer,Boolean> memo= new HashMap<>();
        dfs(nums,0,0,memo);
        return min;
    }

    void dfs(int[] nums,int jmp, int jmpCnt, Map<Integer,Boolean> memo){
        if(jmp>=n-1) {
            if(jmpCnt<min) min=jmpCnt;
            return;
        }
        if(nums[jmp]==0) return;
        // if(nums[jmp]==0){ 
        //     memo.put(nums[jmp],memo.getOrDefault(nums[jmp],false)||false);
        //     return memo.get(nums[jmp]);
        // }
        // if(memo.containsKey(nums[jmp]) && memo.get(nums[jmp])==false) return false;
        // if(!memo.containsKey(nums[jmp])) memo.put(nums[jmp])
        
        int temp = jmp+nums[jmp];
        for(int i=jmp+1;i<=temp && i<n;i++){
            dfs(nums,i,jmpCnt+1,memo);
        }
    }
}
