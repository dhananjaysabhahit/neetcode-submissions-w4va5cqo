class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet();
        for(int num:nums){
            set.add(num);
        }
        int len=0;
        int maxlen=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int cur=nums[i]+1;
                len++;
                while(set.contains(cur)){
                    len++;
                    cur++;
                }
                maxlen=Math.max(maxlen,len);
                len=0;
            }
        }
        return maxlen;
    }
}
