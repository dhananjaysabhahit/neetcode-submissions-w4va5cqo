class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_map = defaultdict(int)
        for i in range(len(nums)):
            num = nums[i]
            if target-num in index_map:
                return [index_map[target-num],i]
            index_map[num]=i
        
        return [0,0]