class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        
        int islandCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    void dfs(char[][] grid, int i, int j){
        if(i<0||i>=grid.length|| j<0|| j>=grid[0].length|| grid[i][j]=='0')
            return;
        grid[i][j]='0';
        for(int m=0;m<directions.length;m++){
            dfs(grid,i+directions[m][0],j+directions[m][1]);
        }
    }
}
