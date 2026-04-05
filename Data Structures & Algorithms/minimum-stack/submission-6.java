class MinStack {
    Stack<int[]> minSt;
    public MinStack() {
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        if(!minSt.isEmpty()){
            int[] topEle =minSt.peek();
            int minEle = Math.min(topEle[1],val); 
            minSt.push(new int[]{val,minEle});
        } else{
            minSt.push(new int[]{val,val});
        }

    }
    
    public void pop() {
        minSt.pop();
    }
    
    public int top() {
        return minSt.peek()[0];
    }
    
    public int getMin() {
        return minSt.peek()[1];
    }
}
