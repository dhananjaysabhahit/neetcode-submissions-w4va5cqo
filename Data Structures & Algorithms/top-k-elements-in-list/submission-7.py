import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # f = Counter(nums)
        
        # heap = []

        # for num,freq in f.items():
        #     heapq.heappush(heap,(freq,num))
        #     if len(heap)>k:
        #         heapq.heappop(heap)

        # res =[]
        
        # for i in range(k):
        #     ele = heapq.heappop(heap)
        #     res.append(ele[1])

        # return res


        # fr = [apple,apple, orange, orange,orange, banana, banana, banana, banana]

        # Counter(fr)

        # res =[]
        # list1 = [[4,banana],[3, orange],...]

        # while len(heap)>0:
        #     # fr1 = heapq.heappop_max()
        #     res.append(banana)

        #     fr1[0]-=1
        #     if fr1[0]:
        #         heapq.heappush_max(heap,fr1)


        # return res

        # freq = [[]]*(len(nums)+1)

        # count = Counter(nums)

        # for item,cnt in count.items():
        #     freq[cnt].append(item)

        # result=[]
        # for i in range(len(freq)-1,0,-1):
        #     while freq[i] and k:
        #         result.append(freq[i].pop())
        #         k-=1
        
        # return result

        f=Counter(nums)

        temp=[]

        for key,val in f.items():
            temp.append([val,key])
        
        temp.sort(reverse=True)
        result=[]
        for i in range(k):
            result.append(temp[i][1])

        return result



        
        




            
