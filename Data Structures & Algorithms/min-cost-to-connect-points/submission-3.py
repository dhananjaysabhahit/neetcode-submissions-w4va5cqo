import heapq
class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        adj = {i:[] for i in range(n)}
        for i in range(n):
            x1,y1 = points[i]
            for j in range(i+1,n):
                x2,y2 = points[j]
                dist = abs(x2-x1)+abs(y2-y1)
                adj[i].append((dist,j))
                adj[j].append((dist,i))

        i = 0
        visit = set()
        heap = [[0,0]]
        res = 0
        while i<n or len(visit)<n:
            cost, pt = heapq.heappop(heap)
            if pt in visit:
                continue
            
            visit.add(pt)
            res+=cost

            for neiCost, nei  in adj[pt]:
                if nei not in visit:
                    heapq.heappush(heap,(neiCost,nei))

            i+=1
        return res
                
