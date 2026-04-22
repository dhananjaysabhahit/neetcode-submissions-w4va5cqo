class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #  Input: nums = [1,2,4,6,7,8]
        pref = [1]*len(nums)
        suff = [1]*len(nums)

        pref[0]=1
        for i in range(1,len(nums)):
            pref[i] = pref[i-1]*nums[i-1]
        
        suff[-1]=1
        for i in range(len(nums)-2,-1,-1):
            suff[i]=suff[i+1]*nums[i+1]
        
        for i in range(len(nums)):
            suff[i]=suff[i]*pref[i]
        
        return suff

