class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        
        flag1 = False
        flag2 = False
        flag3 = False

        for i in range(len(triplets)):
            cur = triplets[i]

            if cur[0]==target[0] and cur[1]<=target[1] and cur[2]<= target[2]:
                flag1 = True
            
            if cur[0]<=target[0] and cur[1]==target[1] and cur[2]<= target[2]:
                flag2 = True

            if cur[0]<=target[0] and cur[1]<=target[1] and cur[2]== target[2]:
                flag3 = True

            if flag1 and flag2 and flag3: return True
        
        return False

            
