class Solution {
    public int findMin(int[] nums) {
        // Java
        // Arrays.stream(nums).min().getAsInt();
        int low=0;
        int high = nums.length-1;
        int res=nums[0];
        while(low<=high){
            if(nums[high]>nums[low]){
                res = Math.min(res,nums[low]);
                break;
            }
            int mid = low+(high-low)/2;
            res= Math.min(res,nums[mid]);
            if(nums[mid]>=nums[low]){
                low=mid+1;
            } else
                high=mid-1;
        
            
        
        }
        return res;
    }
}
