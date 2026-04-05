class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;
        
        Set<Integer> rows = new HashSet<>(); 
        Set<Integer> cols = new HashSet<>(); 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                    
                }
            }
        }

        for(int ele: rows){
            int i=0;
            while(i<n){
                matrix[ele][i]=0;
                i++;
            }
        }

        for(int ele: cols){
            int i=0;
            while(i<m){
                matrix[i][ele]=0;
                i++;
            }
        }
    }
}
