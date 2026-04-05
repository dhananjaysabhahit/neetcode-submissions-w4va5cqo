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
    int[] interval=new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    boolean isValidBST(TreeNode root, int left, int right){
        if(root==null) return true;
        if(root.val>=left || root.val<=right) return false;

        return isValidBST(root.left,root.val,right) & 
            isValidBST(root.right,left,root.val);
    }
}
