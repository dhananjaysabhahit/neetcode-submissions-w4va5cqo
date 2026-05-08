class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # # approach 1
        # d={}
        # for num in nums:
        #     d[num]=0
        
        # i=0
        # for key in d:
        #     nums[i]=key
        #     i+=1
        # return i

        # approach 2

        if len(nums)<=1:
            return len(nums)
        

        l,r=0,1

        while r<len(nums):
            if nums[l]==nums[r]:
                r+=1
            elif r-1 != l:
                nums[l+1],nums[r]=nums[r],nums[l+1]
                r+=1
                l+=1
            else:
                l+=1
                r+=1
        return l+1
        
            




    # 1,1,1,1,1,2,2,3,3
    # l         r

    # 1,2,3,4,5
    #   l,r   
            
