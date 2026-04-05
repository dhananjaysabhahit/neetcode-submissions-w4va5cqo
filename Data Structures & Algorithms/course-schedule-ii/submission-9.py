class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = {i:[] for i in range(numCourses)}

        for crs, pr in prerequisites:
            adj[crs].append(pr)
        
        visited ,cycle= {}, set()
        # res={}
        output =[]

        def dfs(adj,crs)->bool:
            if crs in cycle:
                return False
            # if not adj[crs]:
            #     res[crs]=1
            #     return True
            if crs in visited:
                return True
            
            cycle.add(crs)
            for course in adj[crs]:
                if not dfs(adj,course): return False
            
            # adj[crs]=[]
            # res[crs]=1
            cycle.remove(crs)
            visited[crs]=1
            # output.add(crs)
            return True

        for crs in adj:
            if not dfs(adj,crs): return []

        # return list(res.keys())
        return list(visited.keys())