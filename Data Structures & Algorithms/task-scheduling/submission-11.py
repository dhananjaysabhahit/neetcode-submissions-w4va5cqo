class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq=defaultdict(int)
        for task in tasks:
            freq[task]+=1
        
        maxFreq = max(freq.values())
        maxFreqCnt = 0
        for cur in freq.values():
            if cur==maxFreq:
                maxFreqCnt+=1
        

        
        return max(len(tasks),(n+1)*(maxFreq-1)+maxFreqCnt)


