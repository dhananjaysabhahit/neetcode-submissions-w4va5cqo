class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        adj = defaultdict(list)
        if endWord not in wordList or beginWord==endWord: return 0
        
        wordList.append(beginWord)

        n = len(wordList)
        wm = {}

        for i in range(n):
            wm[wordList[i]]=i
        
        print(wm)
        
        word_len = len(wordList[0])
        word_list_len = len(wordList)

        for i in range(word_list_len-1):
            for j in range(i+1,word_list_len):
                cnt=0
                for k in range(len(wordList[i])):
                    if wordList[i][k]==wordList[j][k]:
                        cnt+=1
                    # print(wordList[j][k])
                
                if cnt==(word_len-1):
                    adj[i].append(j)
                    adj[j].append(i)
                elif i not in adj:
                    adj[i]=[]
        print(adj)
        
        def bfs(adj):
            q=deque()
            q.append(wm[beginWord])
            dist =1
            visited = set()
            while q:
                # print(q)
                for i in range(len(q)):
                    node = q.popleft()
                    visited.add(node)
                    if node==wm[endWord]:
                        return dist
                    for adjNode in adj[node]:
                        if adjNode not in visited:
                            q.append(adjNode)
                dist+=1
                # print(dist)

            return 0

        return bfs(adj)



                        