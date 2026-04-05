class Solution {
    public int maxArea(int[] heights) {
        int left=0,right = heights.length-1;
        int maxArea=0;
        while(left<right){
            int curArea = Math.min(heights[left],heights[right])*(right-left);
            maxArea = Math.max(curArea,maxArea);
            if(heights[left]<heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
