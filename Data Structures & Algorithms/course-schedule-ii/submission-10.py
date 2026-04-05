class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = {i:[] for i in range(numCourses)}
        for cr, pr in prerequisites:
            adj[cr].append(pr)

        vis =  set()
        res = {}

        def dfs(crs)->bool:
            if crs in vis:
                return False
            if not adj[crs]:
                res[crs]=1
                return True

            vis.add(crs)

            for ele in adj[crs]:
                if not dfs(ele):
                    return False

            vis.remove(crs)
            res[crs]=1
            adj[crs]=[]
            return True

        for ele in adj.keys():
            if not dfs(ele):
                return []
        return list(res.keys())