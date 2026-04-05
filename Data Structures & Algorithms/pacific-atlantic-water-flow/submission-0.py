class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(heights), len(heights[0])
        directions = [[0,1],[1,0],[-1,0],[0,-1]]

        pac, atl = set(), set()

        # DFS
        def dfs(r, c, prevHeight, visited):
            if (r,c) in visited or r<0 or c<0 or r==ROWS or c==COLS or heights[r][c]<prevHeight:
                return
            visited.add((r,c))

            for dir in directions:
                dfs(r+dir[0],c+dir[1],heights[r][c],visited)



        for i in range(ROWS):
            dfs(i,0,0,pac)
            dfs(i,COLS-1,0,atl)
        
        for i in range(COLS):
            dfs(0,i,0,pac)
            dfs(ROWS-1,i,0,atl)

        res=[]
        for i in range(ROWS):
            for j in range(COLS):
                if (i,j) in pac and (i,j) in atl:
                    res.append([i,j])
        return res
