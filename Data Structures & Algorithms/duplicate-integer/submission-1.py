class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        check_unique_set = set()
        for num in nums:
            if num in check_unique_set:
                return True
            check_unique_set.add(num)
        return False