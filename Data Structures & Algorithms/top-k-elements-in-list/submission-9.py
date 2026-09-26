import heapq
from collections import Counter


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        heap = []
        for key,val in count.items():
            heapq.heappush_max(heap,[val,key])

        result = []
        for i in range(k):
            ele = heapq.heappop_max(heap)
            result.append(ele[1])
        
        return result

        

        



