class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int INF = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int n= q.size();
            for(int i=0;i<n;i++){
                int[] ele = q.poll();
                int row = ele[0];
                int col = ele[1];
                int cell = grid[row][col];
                
                for(int[] dir: directions){
                    int newROW = row+dir[0];
                    int newCOL = col+dir[1];
                    if(newROW<0 || newCOL<0 || newROW>=grid.length || newCOL>=grid[0].length || grid[newROW][newCOL]!=INF)
                        continue;
                    q.offer(new int[]{newROW,newCOL});
                    grid[newROW][newCOL]=grid[row][col]+1;
                }
            }

        }
    }   
}
