class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = 0
        while l<=r:
            mid = (l+r)//2
            if self.canEat(piles,mid,h):
                res=mid
                r=mid-1
            else:
                l=mid+1
        return res

    def canEat(self,piles,mid,h) -> bool:
        total=0
        for pile in piles:
            total+= math.ceil(pile/mid)
        return total<=h