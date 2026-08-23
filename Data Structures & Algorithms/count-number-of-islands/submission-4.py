class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        directions = [[0,1],[1,0],[0,-1],[-1,0]]

        m = len(grid)-1
        n = len(grid[0])-1
        
        def dfs(i,j):
            
            if i>m or j>n or i<0 or j<0:
                return 0
                
            if  grid[i][j]=="0":
                return 0

            grid[i][j] ="0"
            
            for direction in directions:
                dfs(i+direction[0],j+direction[1])

            return 1

        count =0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    count +=dfs(i,j)

        return count

        

