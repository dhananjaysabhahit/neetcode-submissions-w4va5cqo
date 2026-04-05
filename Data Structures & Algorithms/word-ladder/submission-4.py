class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or endWord==beginWord:
            return 0
        wordList.append(beginWord)
        adj ={wordList[i]:[] for i in range(len(wordList))}

        for i in range(len(wordList)-1):
            for j in range(i+1, len(wordList)):
                cnt =0 
                for k in range(len(wordList[i])):
                    if wordList[i][k]!=wordList[j][k]:
                        cnt+=1
                if cnt==1:
                    adj[wordList[i]].append(wordList[j])
                    adj[wordList[j]].append(wordList[i])

        def bfs(word)->bool:
            q= deque()
            q.append(word)
            visited = set()
            count=1
            while q:
                for i in range(len(q)):
                    cur_word = q.popleft()
                    visited.add(cur_word)
                    if cur_word==endWord:
                        return count
                    
                    for ele in adj[cur_word]:
                        if ele not in visited:
                            q.append(ele)
                count+=1
            return 0

        return bfs(beginWord)