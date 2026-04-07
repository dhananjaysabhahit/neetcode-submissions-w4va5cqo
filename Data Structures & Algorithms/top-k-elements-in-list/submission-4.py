import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        f = Counter(nums)
        
        heap = []

        for num,freq in f.items():
            heapq.heappush(heap,(freq,num))
            if len(heap)>k:
                heapq.heappop(heap)

        res =[]
        
        for i in range(k):
            ele = heapq.heappop(heap)
            res.append(ele[1])
    

        return res
