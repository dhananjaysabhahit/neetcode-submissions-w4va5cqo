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

        # solution 2 naive bfs
        # adj = [[] for i in range(n)]
        # visited = set()

        # for u,v in edges:
        #     adj[u].append(v)
        #     adj[v].append(u)

        # def bfs(node):
        #     q = deque()
        #     q.append(node)
        #     while q:
        #         cur_node = q.popleft()
        #         visited.add(cur_node)

        #         for nei in adj[cur_node]:
        #             if nei not in visited:
        #                 q.append(nei)


        # con_comp = 0
        # for node in range(n):
        #     if node not in visited:
        #         bfs(node)
        #         con_comp+=1

        # return con_comp

        #solution 3 disjoint set union
        par  = [i for i in range(n)]
        rank = [1] * n

        def find(node):
            res = node

            while res != par[res]:
                par[res] =  par[par[res]]
                res = par[res]

            return res

        def union(n1, n2):
            p1, p2 = find(n1), find(n2)

            if p1==p2:
                return 0
            else:
                if rank[p1] > rank[p2]:
                    rank[p1]+=rank[p2]
                    par[p2] = p1
                else:
                    rank[p2]+=rank[p1]
                    par[p1] = p2
                return 1

        res = n

        for u,v in edges:
            res -= union(u,v)
        return res





        