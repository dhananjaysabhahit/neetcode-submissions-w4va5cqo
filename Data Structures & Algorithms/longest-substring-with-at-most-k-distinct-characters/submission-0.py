class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        smap = defaultdict(int)

        maxLen, l = 0, 0
        for idx,c in enumerate(s):
            smap[c]+=1

            if len(smap)<=k:
                maxLen = max(maxLen,idx-l+1)
            
            while len(smap)>k:
                d = s[l]
                smap[d]-=1

                if not smap[d]: smap.pop(d)
                l+=1
        
        return maxLen