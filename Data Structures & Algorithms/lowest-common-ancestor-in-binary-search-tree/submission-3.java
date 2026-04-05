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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // approach 1
        // if(root==null || p==null || q==null)
        //     return null;
        // if(Math.max(p.val,q.val)<root.val)
        //     return lowestCommonAncestor(root.left,p,q);
        // else if(Math.min(p.val,q.val)>root.val)
        //     return lowestCommonAncestor(root.right,p,q);
        // else 
        //     return root;

        //apprach 2

        TreeNode cur=root;
        while(cur!=null){
            if(cur.val<p.val && cur.val<q.val)
                cur=cur.right;
            else if(cur.val>p.val && cur.val>q.val)
                cur=cur.left;
            else return cur;
        }
        return null;
    }
}
