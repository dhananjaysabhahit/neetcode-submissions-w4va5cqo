class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int[] prefExt = new int[n];
        int[] suffExt= new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            
            prefExt[i] = !st.isEmpty() ? st.peek()+1:0; 
            st.push(i);
            
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            
            suffExt[i] = !st.isEmpty() ? st.peek()-1:n-1; 
            st.push(i);
        }
        int maxArea =0;
        for(int i=0;i<n;i++){
            int curArea = (suffExt[i]-prefExt[i]+1)*heights[i];
            maxArea = Math.max(curArea,maxArea);
        }
        return maxArea;
    }
}
