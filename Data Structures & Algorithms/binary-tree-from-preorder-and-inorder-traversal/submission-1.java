/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    Map<Integer,Integer> idxmap = new HashMap<>();
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            idxmap.put(inorder[i],i);
        }       
        return dfs(preorder,0,inorder.length-1);
    }

    public TreeNode dfs(int[] preorder,int l,int r){
        if(l>r) return null;
        int mid=idxmap.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left=dfs(preorder,l,mid-1);
        root.right=dfs(preorder,mid+1,r);
        
        return root;
    }

    
}
