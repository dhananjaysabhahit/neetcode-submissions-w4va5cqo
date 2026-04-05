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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(q==null && p==null)
        //     return true;
        // if((p==null || q==null) || (q.val!=p.val))
        //     return false;
        // return isSameTree(p.left,q.left) & isSameTree(p.right,q.right);

        // iterative DFS

        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{p,q});

        while(!st.isEmpty()){
            TreeNode[] nodes = st.pop();
            if(nodes[0]==null && nodes[1]==null)
                continue;
            if(nodes[0]==null || nodes[1]==null || nodes[0].val!=nodes[1].val)
                return false;
            st.push(new TreeNode[]{nodes[0].left,nodes[1].left});
            st.push(new TreeNode[]{nodes[0].right,nodes[1].right});
        }
        return true;
    }
}