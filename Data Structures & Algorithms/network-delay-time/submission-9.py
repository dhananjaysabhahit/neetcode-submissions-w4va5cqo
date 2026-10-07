import heapq
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        # solution 1 dijkstra
        # adj = {i:[] for i in range(1,n+1)}

        # for u,v,w in times:
        #     adj[u].append([v,w])

        # heap = [[0,k]]
        # vis = set()
        # time = 0

        # while heap:
        #     wei,node =  heapq.heappop(heap)

        #     if node in vis:
        #         continue

        #     vis.add(node)

        #     time =  wei
        
        #     for nei, neiW in adj[node]:
        #         if nei not in vis:
        #             heapq.heappush(heap,[neiW+wei,nei])
        
        # return time if len(vis)==n else -1


        # solution 2 bellman ford algorithm
        dist = [math.inf]* (n+1)

        dist[k], dist[0] = 0,0
        for i in range(n):
            for u,v,w in times:
                if dist[u]+w < dist[v]:
                    dist[v] = dist[u]+w
        max_dist = max(dist)
        return max_dist if max_dist< math.inf else -1
