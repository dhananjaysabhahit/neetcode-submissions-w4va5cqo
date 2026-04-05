class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS = len(board)
        COLS = len(board[0])
        connZeroes = set()
        directions = [[1,0],[-1,0],[0,1],[0,-1]]

        def dfs(board,i,j):

            if i<0 or i==ROWS or j<0 or j==COLS or board[i][j]!='O' or ((i,j) in connZeroes):
                return
            
            connZeroes.add((i,j))
            for dir in directions:
                dfs(board,i+dir[0],j+dir[1])


        for i in range(ROWS):
            if board[i][0]=='O':
                dfs(board,i,0)
            if board[i][COLS-1]=='O':
                dfs(board,i,COLS-1)

        for i in range(COLS):
            if board[0][i]=='O':
                dfs(board,0,i)
            if board[ROWS-1][i]=='O':
                dfs(board,ROWS-1,i)
        print(connZeroes)
        
        for i in range(ROWS):
            for j in range(COLS):
                if (i,j) not in connZeroes and board[i][j]=='O':
                    board[i][j]='X'
        
