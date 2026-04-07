import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        f = Counter(nums)
        
        heap = []

        for num,freq in f.items():
            heapq.heappush_max(heap,(freq,num))

        res =[]


        
        for i in range(k):
            ele = heapq.heappop_max(heap)
            res.append(ele[1])
    

        return res
