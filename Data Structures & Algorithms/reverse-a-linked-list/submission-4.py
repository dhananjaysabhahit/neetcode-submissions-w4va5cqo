# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # # approach 1
        # arr=[]
        # tmp = head
        # while tmp!=None:
        #     arr.append(tmp.val)
        #     tmp=tmp.next

        # tmp=head
        # while tmp!=None:
        #     tmp.val=arr.pop()
        #     tmp=tmp.next

        # return head

        # approach 2
        cur = head
        prev=None
        while cur!=None:
            nextNode = cur.next
            cur.next=prev
            prev=cur
            cur=nextNode

        return prev
