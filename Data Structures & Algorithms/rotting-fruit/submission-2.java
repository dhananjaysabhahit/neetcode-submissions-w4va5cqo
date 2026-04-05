class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    boolean isValidStep(int i, int j,int[][] grid){
        if(i<0 || i>=grid.length ||j<0 ||j>=grid[0].length || grid[i][j]!=1){
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        int fresh=0, rotten=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    rotten++;
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        if(rotten==0){
            return -1;
        }
        int count=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                int[] cur=q.poll();
                for(int j=0;j<directions.length;j++){
                    if(isValidStep(cur[0]+directions[j][0],cur[1]+directions[j][1],grid)){
                        q.offer(new int[]{cur[0]+directions[j][0],cur[1]+directions[j][1]});
                        grid[cur[0]+directions[j][0]][cur[1]+directions[j][1]]=2;
                    }
                }
            }
            count++;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return count-1;
    }
}
