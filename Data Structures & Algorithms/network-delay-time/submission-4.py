import heapq
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        # adj = {i:[] for i in range(1,n+1)}

        # for u,v,w in times:
        #     adj[u].append([v,w])

        # heap = [[0,k]]
        # vis = set()
        # time = 0

        # while heap:
        #     w,n =  heapq.heappop(heap)

        #     if n in vis:
        #         continue

        #     vis.add(n)

        #     time =  w
        
        #     for nei, neiW in adj[n]:
        #         if nei not in vis:
        #             heapq.heappush(heap,[neiW+w,nei])
        
        # return time if len(vis)==n else -1




        edges = collections.defaultdict(list)
        for u, v, w in times:
            edges[u].append((v, w))

        minHeap = [(0, k)]
        visit = set()
        t = 0
        while minHeap:
            w1, n1 = heapq.heappop(minHeap)
            if n1 in visit:
                continue
            visit.add(n1)
            t = w1

            for n2, w2 in edges[n1]:
                if n2 not in visit:
                    heapq.heappush(minHeap, (w1 + w2, n2))
        return t if len(visit) == n else -1

        
