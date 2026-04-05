# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        def isLeafNode(root)->bool:
            if root.left is None and root.right is None:
                return True

        def dfs(root,pathSum)->bool:
            pathSum +=root.val
            if isLeafNode(root) and pathSum == targetSum: return True
            elif isLeafNode(root): return False
            left = False
            if root.left:
                left = dfs(root.left,pathSum)

            right = False
            if root.right:
                right = dfs(root.right,pathSum)
            return left or right

        pathSum =0 
        if not root:
            return False
        return dfs(root,pathSum)

    
        