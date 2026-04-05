class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        idxmap ={}
        for i,num in enumerate(nums):
            if target-num in idxmap:
                return [idxmap[target-num],i]
            if num not in idxmap:
                idxmap[num]=i
            
