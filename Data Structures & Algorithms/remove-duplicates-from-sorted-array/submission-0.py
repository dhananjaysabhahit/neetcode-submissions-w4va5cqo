class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        d={}
        for num in nums:
            d[num]=0
        
        i=0
        for key in d:
            nums[i]=key
            i+=1
        return i