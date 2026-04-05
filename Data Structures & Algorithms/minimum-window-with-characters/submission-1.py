from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tcount = Counter(t)
        tlen = len(t)
        window = {}
        
        sublen = math.inf
        res=[-1,-1]
        cnt=0
        l=0
        for i in range(len(s)):
            c = s[i]
            window[c]=window.get(c,0)+1

            if  tcount[c]>=window[c]:
                cnt+=1
            
            while cnt==tlen:
                if (i-l+1)<sublen:
                    sublen=i-l+1
                    res=[l,i]
                d=s[l]
                window[d]-=1
                if d in tcount and tcount[d]>window[d]:
                    cnt-=1
                l+=1
        
        return s[res[0]:res[1]+1]


        