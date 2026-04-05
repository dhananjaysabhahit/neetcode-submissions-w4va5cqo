class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length-1,n=matrix[0].length-1;
        int l=0,h=m;
        int dRow=-1;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            if(matrix[mid][0]==target || matrix[mid][n]==target)
                return true;
            else if(matrix[mid][0]<target && matrix[mid][n]>target){
                dRow=mid;
                break;
            } else if(matrix[mid][0]>target)
                h=mid-1;
            else if(matrix[mid][n]<target){
                l=mid+1;
            }
        }
        l=0;
        h=n-1;
        if(dRow==-1)
            return false;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(matrix[dRow][mid]==target)
                return true;
            else if(matrix[dRow][mid]<target)
                l=mid+1;
            else
                h=mid-1;
        }
        return false;
    }
}
