class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] rightMax = new int[n];

        int max=0;
        
        for(int i=n-1;i>=0;i--){
            if(height[i]>max){
                max=height[i];
            }
            rightMax[i] = max;
        }
        max =0;
        int total=0;
        for(int i=0;i<n;i++){
            if(height[i]>max){
                max=height[i];
            }
            int curWater = Math.min(rightMax[i],max)-height[i];
            if(curWater>0){
                total+=curWater;
            }
        }

        return total;
    }
}
