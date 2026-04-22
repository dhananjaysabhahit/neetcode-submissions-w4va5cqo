class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = defaultdict(int)
        
        l, maxlen=0,0
        for r in range(len(s)):
            c=s[r]
            window[c]+=1

            while window[c]>1:
                d = s[l]
                window[d]-=1
                l+=1
             
            maxlen = max(maxlen,(r-l+1))

        return maxlen






