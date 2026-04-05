class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> rowSet = new HashSet();
            Set<Character> colSet = new HashSet();
            for(int j=0;j<9;j++){
                char rowChar =board[i][j];
                char colChar = board[j][i];
                
                if(rowChar!='.' && rowSet.contains(rowChar)){
                    return false;
                } else if(rowChar!='.'){
                    rowSet.add(rowChar);
                }
                if(colChar!='.' && colSet.contains(colChar)){
                    return false;
                } else if(colChar!='.'){
                    colSet.add(colChar);
                }
            }
        }
        Map<String, Set<Character>> smap= new HashMap<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                String sKey = (i/3)+","+(j/3);
                if(board[i][j]=='.')
                    continue;
                if(smap.computeIfAbsent(sKey,k->new HashSet()).contains(board[i][j])){
                    return false;
                }
                smap.get(sKey).add(board[i][j]);
            }
        }
        return true;
    }
}
