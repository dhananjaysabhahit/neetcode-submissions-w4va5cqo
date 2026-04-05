class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nextGreater = -1;
        for(int j=0;j<nums1.length;j++){
            nextGreater=-1;
            for(int i=nums2.length-1;i>=0;i--){
                if(nums2[i]>nums1[j]){
                    nextGreater=nums2[i];
                } else if(nums2[i]==nums1[j]){
                    nums1[j]=nextGreater;
                    break;
                }
            }
        }
        return nums1;
    }
}