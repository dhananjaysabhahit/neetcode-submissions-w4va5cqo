class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int[] curArea=new int[]{0};
        int maxArea=0;
    
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,curArea);
                    if(curArea[0]>maxArea) maxArea = curArea[0];
                    curArea[0]=0;
                }
            }
        }
        return maxArea;
    }

    void dfs(int[][] grid, int i,int j,int[] curArea){
        if(i<0 || j<0|| i>=grid.length || j>=grid[0].length|| grid[i][j]==0){
            return;
        }
        grid[i][j] = 0;
        curArea[0]++;
        
        for(int m=0;m<directions.length;m++)
            dfs(grid,i+directions[m][0],j+directions[m][1],curArea);

    }
}
