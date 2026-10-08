import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = collections.Counter(nums)

        min_heap = []

        for key, val in freq_map.items():
            heapq.heappush(min_heap,(val,key))
            if len(min_heap)>k:
                heapq.heappop(min_heap)
            
        return [val[1] for val in min_heap]
        

