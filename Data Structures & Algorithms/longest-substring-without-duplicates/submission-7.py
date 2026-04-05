class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = defaultdict(int)

        l, maxlen=0,0
        for i in range(len(s)):
            c=s[i]
            while window[c]>0:
                d = s[l]
                window[d]-=1
                l+=1
                print("here")
            window[c]+=1
            maxlen = max(maxlen,(i-l+1))
            print(maxlen,i,l)
        return maxlen


