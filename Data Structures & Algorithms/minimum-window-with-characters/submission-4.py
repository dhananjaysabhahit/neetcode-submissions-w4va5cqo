class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(t)>len(s): return ""
        slen, tlen = len(s), len(t)
        
        tmap ,smap= Counter(t), defaultdict(int)

        l, cnt = 0, 0
        res , sublen = [0,0], math.inf

        for idx,c in enumerate(s):
            smap[c]+=1

            if c in t and smap[c]<=tmap[c]:
                cnt+=1
            
            while cnt==tlen:
                if idx-l+1<sublen:
                    sublen = idx-l+1
                    res = [l,idx+1]
                
                d = s[l]
                smap[d]-=1
                if smap[d]<tmap[d]:
                    cnt-=1
                l+=1
        
        return s[res[0]:res[1]]
                



            