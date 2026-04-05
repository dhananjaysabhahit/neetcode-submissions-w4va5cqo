"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        pAnc, qAnc=deque(),deque()
        while p!=None:
            pAnc.append(p)
            p=p.parent
        
        while q!=None:
            qAnc.append(q)
            q=q.parent

        for i in pAnc:
            for j in qAnc:
                if i==j:
                    return i
        

