import heapq

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:

        n = len(points)
        edges = {i:[] for i in range(n)}
        
        
        for i in range(n):
            x1,y1 = points[i]
            for j in range(i+1,n):
                x2,y2 = points[j]
                dist = abs(x1-x2)+abs(y1-y2)
                edges[i].append((dist,j))
                edges[j].append((dist,i))

        visit = set()
        res = 0
        heap = [[0,0]]
            
        i=0
        while i< n and len(visit)<n:
            cost, pt = heapq.heappop(heap)

            if pt in visit:
                continue

            res+=cost
            visit.add(pt)

            for neiCost, nei in edges[pt]:
                if nei not in visit:
                    heapq.heappush(heap,(neiCost,nei))
            i+=1
        
        return res



