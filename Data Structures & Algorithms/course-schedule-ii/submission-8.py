class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = {i:[] for i in range(numCourses)}

        for crs, pr in prerequisites:
            adj[crs].append(pr)
        
        visited = set()
        res={}

        def dfs(adj,crs)->bool:
            if crs in visited:
                return False
            if not adj[crs]:
                res[crs]=1
                return True
            
            visited.add(crs)
            for course in adj[crs]:
                if not dfs(adj,course): return False
            
            adj[crs]=[]
            
            res[crs]=1
            visited.remove(crs)
            return True

        for crs in adj:
            if not dfs(adj,crs): return []

        return list(res.keys())