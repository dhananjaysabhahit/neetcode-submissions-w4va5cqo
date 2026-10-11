class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = [[] for i in range(n)]
        visited = set()

        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def dfs(node):
            visited.add(node)
            for nei in adj[node]:
                if nei not in visited:
                    dfs(nei)


        con_comp = 0
        for node in range(n):
            if node not in visited:
                dfs(node)
                con_comp+=1

        return con_comp



        