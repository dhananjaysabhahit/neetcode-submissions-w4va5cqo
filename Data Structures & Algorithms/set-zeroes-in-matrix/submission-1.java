class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;
        
        int rowZero=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    if(i!=0){
                        matrix[i][0]=0;
                    } else{
                        rowZero=0;
                    }
                }
            }
        }

        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                int j=0;
                while(j<n) {
                    matrix[i][j]=0;
                    j++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                int j=0;
                while(j<m) {

                    matrix[j][i]=0;
                    j++;
                }
            }
        }

        if(rowZero==0) {
            for(int i=0;i<n;i++) matrix[0][i]=0;
        }
    }
}
