class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] res = new int[size];
        
        res[0]=1;
        int prefProd = 1;
        for(int i=0;i<size;i++){
            res[i] = prefProd;
            prefProd*=nums[i];
        }
        int postProd = 1;
        for(int i=size-1;i>=0;i--){
            res[i] *= postProd;
            postProd*=nums[i];
        }
        return res;
    }
}  
