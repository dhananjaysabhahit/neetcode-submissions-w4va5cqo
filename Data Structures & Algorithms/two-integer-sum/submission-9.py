class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # idxmap ={}
        # # for i,num in enumerate(nums):
        # #     if target-num in idxmap:
        # #         return [idxmap[target-num],i]
        # #     if num not in idxmap:
        # #         idxmap[num]=i

        # nums.sort()
        # l, r=0, len(nums)-1
        # while l<r:
        #     curSum=nums[l]+nums[r]
        #     if curSum == target:
        #         return [l,r]
        #     elif curSum<target:
        #         l+=1
        #     else:
        #         r-=1
        # return []

        d ={}

        for i in range(len(nums)):
            d[nums[i]] = i


        for i in range(len(nums)):

            if target-nums[i] in d and d[target-nums[i]]!=i:
                idx =d[target-nums[i]]
                return [min(idx,i),max(idx,i)]


            
