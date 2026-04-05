class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj = {i:set() for i in range(numCourses)}
        for crs,pr in prerequisites:         
            adj[crs].add(pr)

        visited = set()

        def dfs(adj,course)-> bool:
            if course in visited:
                return False
            if not adj[course]:
                return True

            visited.add(course)

            for pr in adj[course]:
                if not dfs(adj,pr): return False
            visited.remove(course)
            adj[course] = []
            return True

        for crs in range(numCourses):
            if adj[crs]:
                if not dfs(adj,crs): return False
        
        return True


            
