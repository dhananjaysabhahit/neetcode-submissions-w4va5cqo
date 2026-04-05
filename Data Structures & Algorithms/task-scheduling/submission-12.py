class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = Counter(tasks)

        maxf = max(freq.values())

        maxfCnt=0
        for cur in freq.values():
            if cur==maxf:
                maxfCnt+=1
        
        return max(len(tasks),(n+1)*(maxf-1)+maxfCnt)