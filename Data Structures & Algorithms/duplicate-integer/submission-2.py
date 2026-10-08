class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # solution 1
        # check_unique_set = set()
        # for num in nums:
        #     if num in check_unique_set:
        #         return True
        #     check_unique_set.add(num)
        # return False

        # solution 2
        return len(set(nums))!=len(nums)