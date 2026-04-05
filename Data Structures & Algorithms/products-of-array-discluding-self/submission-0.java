class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int size = nums.length;
        int[] pref = new int[size];
        int[] suf = new int[size];
        pref[0]=1;
        suf[size-1]=1;
        for(int i=1;i<size;i++){
            pref[i] = pref[i-1]*nums[i-1];
            suf[size-i-1] = suf[size-i]*nums[size-i];
        }
        for(int i=0;i<size;i++){
            nums[i]=pref[i]*suf[i];
        }
        return nums;
    }
}  
