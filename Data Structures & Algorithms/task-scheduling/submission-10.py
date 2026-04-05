class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq=defaultdict(int)
        for task in tasks:
            freq[task]+=1
        
        maxFreqCnt =0
        print(freq)

        maxFreq = max(freq.values())
        maxFreqEle = max(freq,key=freq.get)
        freq.pop(maxFreqEle)
        print(freq)
        
        curFreq = 0
        cnt=0
        while freq:
            curFreq = max(freq.values())
            curFreqEle = max(freq,key=freq.get)
            freq.pop(curFreqEle)
            print(freq)
            if curFreq !=maxFreq:
                break
            cnt+=1
        
        return max(len(tasks),maxFreq+(n*(maxFreq-1))+cnt)


