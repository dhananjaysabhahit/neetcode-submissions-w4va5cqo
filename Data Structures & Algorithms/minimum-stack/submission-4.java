class MinStack {
    Stack<Integer> st;
    Stack<Integer> prefst;
    int min;

    public MinStack() {
        st = new Stack<>();
        prefst = new Stack<>();
    }
    
    public void push(int val) {
        if(!prefst.isEmpty()){
            prefst.push(Math.min(prefst.peek(),val));
        } else{
            prefst.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        st.pop();
        prefst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return prefst.peek();
    }
}
