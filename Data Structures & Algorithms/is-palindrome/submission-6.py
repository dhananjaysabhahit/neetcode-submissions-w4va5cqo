class Solution:
    def isPalindrome(self, s: str) -> bool:
        # n = len(s)
        # l ,r =0, n-1

        # while l<r:
        #     while not s[l].isalnum() and l<r:
        #         l+=1
        #     while not s[r].isalnum() and l<r:
        #         r-=1

        #     if s[l].lower()==s[r].lower():
        #         l+=1
        #         r-=1
        #     else:
        #         return False
        # return True

        #solution 2
        return (cleaned := [c.lower() for c in s if c.isalnum()]) == cleaned[::-1]


        