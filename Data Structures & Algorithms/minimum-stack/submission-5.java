class MinStack {
    Stack<Integer> st;
    Stack<Integer> prefst;
    //approach 2
    Stack<int[]> sst;
    int min;

    public MinStack() {
        st = new Stack<>();
        prefst = new Stack<>();
        //approach 2
        sst = new Stack<>();
    }
    
    public void push(int val) {
        if(!prefst.isEmpty()){
            prefst.push(Math.min(prefst.peek(),val));
        } else{
            prefst.push(val);
        }
        st.push(val);

        //approach 2
        if(!sst.isEmpty()){
            sst.push(new int[]{val,Math.min(sst.peek()[1],val)});
        } else{
            sst.push(new int[] {val,val});
        }

    }
    
    public void pop() {
        st.pop();
        prefst.pop();
        //approach 2
        sst.pop();
    }
    
    public int top() {
        // return st.peek();
        //approach 2
        return sst.peek()[0];
    }
    
    public int getMin() {
        // return prefst.peek();
        return sst.peek()[1];
    }
}
