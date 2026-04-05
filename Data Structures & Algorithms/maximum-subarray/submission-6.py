class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curSum = 0
        maxSum = -math.inf

        for num in nums:
            if curSum < 0:
                curSum=0

            curSum+=num

            if curSum > maxSum:
                maxSum = curSum
        return maxSum