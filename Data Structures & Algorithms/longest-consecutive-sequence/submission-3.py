class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # Input: nums = [2,20,4,10,3,4,5,1]
        numset=set(nums)
        maxLen=0
        for num in nums:
            if num-1 not in numset:
                curLen=0
                while num in numset:
                    curLen+=1
                    num+=1
                maxLen=max(curLen,maxLen)
        
        return maxLen

        