# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False

        stack =[]
        pathSum =0
        stack.append([root,root.val])

        def isLeafNode(root)->bool:
            return not root.left and not root.right

        while stack:
            
            root, pathSum = stack.pop()
            
            if isLeafNode(root) and pathSum == targetSum:
                return True
            
            if root.left:
                stack.append([root.left,pathSum+root.left.val])
            if root.right:
                stack.append([root.right,pathSum+root.right.val])
        return False
            

