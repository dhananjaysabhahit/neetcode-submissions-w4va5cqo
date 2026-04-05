class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> pfst = new Stack<>();
        for(String str: tokens){
            
            int res; 
            if(str.equals("+") ){
                int op1 = Integer.parseInt(pfst.pop());
                int op2 = Integer.parseInt(pfst.pop());
                res = op1+op2;
                pfst.push(String.valueOf(res));
            } else if(str.equals("-")){
                int op1 = Integer.parseInt(pfst.pop());
                int op2 = Integer.parseInt(pfst.pop());
                res = op2-op1;
                pfst.push(String.valueOf(res));
            } else if(str.equals("*")){
                int op1 = Integer.parseInt(pfst.pop());
                int op2 = Integer.parseInt(pfst.pop());
                res = op1*op2;
                pfst.push(String.valueOf(res));
            } else if(str.equals("/")){
                int op1 = Integer.parseInt(pfst.pop());
                int op2 = Integer.parseInt(pfst.pop());
                if(op2!=0)
                    res = op2/op1;
                else
                    res=0;
                pfst.push(String.valueOf(res));
            } else {
                pfst.push(str);
            }
        }
        return Integer.valueOf(pfst.pop());
    }
}
