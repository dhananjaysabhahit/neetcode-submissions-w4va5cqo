class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        # solution 1 naive dfs
        # adj = [[] for i in range(n)]
        # visited = set()

        # for u,v in edges:
        #     adj[u].append(v)
        #     adj[v].append(u)

        # def dfs(node):
        #     visited.add(node)
        #     for nei in adj[node]:
        #         if nei not in visited:
        #             dfs(nei)


        # con_comp = 0
        # for node in range(n):
        #     if node not in visited:
        #         dfs(node)
        #         con_comp+=1

        # return con_comp

        # solution 1 naive dfs
        adj = [[] for i in range(n)]
        visited = set()

        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def bfs(node):
            q = deque()
            q.append(node)
            while q:
                cur_node = q.popleft()
                visited.add(cur_node)

                for nei in adj[cur_node]:
                    if nei not in visited:
                        q.append(nei)


        con_comp = 0
        for node in range(n):
            if node not in visited:
                bfs(node)
                con_comp+=1

        return con_comp





        