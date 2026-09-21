from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        q = deque()

        fresh, time = 0, 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i, j])
                if grid[i][j] == 1:
                    fresh += 1

        def bfs(q):
            nonlocal fresh, time  # refer to the fresh/time defined in orangesRotting, not module globals
            while q and fresh > 0:
                qlen = len(q)

                for i in range(qlen):
                    ele = q.popleft()

                    for dir in directions:
                        row, col = ele[0] + dir[0], ele[1] + dir[1]
                        if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col] == 1:
                            q.append([row, col])
                            grid[row][col] = 2
                            fresh -= 1
                time += 1

        bfs(q)

        return time if fresh == 0 else -1