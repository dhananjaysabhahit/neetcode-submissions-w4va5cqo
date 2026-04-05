class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj = {}
        # for i in range(numCourses):
        #     for j in range(numCourses):
        #         if j==0:
        #             adj.append([])
        #         adj[i].append(0)
        
        # for pr in prerequisites:
        #     adj[pr[0]][pr[1]]=1

        for pr in prerequisites:
            if pr[0] not in adj:
                adj[pr[0]]=set()
            if pr[1] not in adj:
                adj[pr[1]]=set()
            adj[pr[0]].add(pr[1])

        visited = set()

        def dfs(adj,course)-> bool:
            if course in visited:
                return False

            visited.add(course)
            res = True
            for pr in adj[course]:
                res = res & dfs(adj,pr)
            visited.remove(course)
            return res
            
        res = True
        for course in adj.keys():
            if adj[course]:
                res = res & dfs(adj,course)
        
        return res


            
