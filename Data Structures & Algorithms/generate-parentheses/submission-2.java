class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==1){
            return List.of("()");
        }
        int open=1, close=0;
        StringBuilder str = new StringBuilder().append('(');
        List<String> res = new ArrayList<>();
        dfs(n,open,close,str,res);
        return res;
    }

    void dfs(int n, int open, int close, StringBuilder str, List<String> res){
        if(str.length()==2*n){
            res.add(str.toString());
            return;
        }
        if(open>n || close>n)
            return;
        if(close<open){
            str.append(')');
            dfs(n,open,close+1,str,res);
            str.deleteCharAt(str.length()-1);
        }
        if (open<n){
            str.append('(');
            dfs(n,open+1,close,str,res);
            str.deleteCharAt(str.length()-1);
        }
    }
}
