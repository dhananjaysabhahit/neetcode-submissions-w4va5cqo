import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # solution heap with map
        # freq_map = collections.Counter(nums)

        # min_heap = []

        # for key, val in freq_map.items():
        #     heapq.heappush(min_heap,(val,key))
        #     if len(min_heap)>k:
        #         heapq.heappop(min_heap)
            
        # return [val[1] for val in min_heap]

        # solution 2
        counter_map = collections.Counter(nums)
        n = len(nums)

        freq = [[] for i in range(n+1)]

        for num, cnt in counter_map.items():
            freq[cnt].append(num)

        res = []
        for i in range(n,0,-1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res


