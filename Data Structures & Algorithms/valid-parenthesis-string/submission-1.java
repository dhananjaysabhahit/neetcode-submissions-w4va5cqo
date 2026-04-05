class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        if(n==1) return s.charAt(0)=='*'? true:false;

        Stack<Integer> openSt = new Stack<>();
        Stack<Integer> starSt = new Stack<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='(') openSt.push(i);
            else if(c=='*') starSt.push(i);
            else if(c==')') {
                if(!openSt.isEmpty())
                    openSt.pop();
                else if(!starSt.isEmpty())
                    starSt.pop();
                else
                    return false;
            }
        }
        while(!openSt.isEmpty() && !starSt.isEmpty()){
            if(openSt.pop()>starSt.pop()) return false;
        } 
        return openSt.isEmpty()? true: false;
    }
}
