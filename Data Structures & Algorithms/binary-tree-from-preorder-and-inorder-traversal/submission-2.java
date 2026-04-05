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
      
        //approach 1
        // return dfs(preorder,0,inorder.length-1);
        //approach 2
        return dfs(preorder,inorder);
    }

    public TreeNode dfs(int[] preorder,int[] inorder){
        //approach 1
        // if(l>r) return null;
        // int mid=idxmap.get(preorder[idx]);
        // TreeNode root = new TreeNode(preorder[idx]);
        // idx++;
        // root.left=dfs(preorder,l,mid-1);
        // root.right=dfs(preorder,mid+1,r);
        
        // return root;
        //approach 2
        if(preorder.length==0 || inorder.length==0)
            return null;
        int rootval=preorder[0];
        TreeNode root = new TreeNode(rootval);
        int mid=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                mid=i;
                break;
            }
        }


        int[] leftpreorder= Arrays.copyOfRange(preorder,1,mid+1);
        int[] leftinorder= Arrays.copyOfRange(inorder,0,mid);
        root.left=dfs(leftpreorder,leftinorder);
        int[] rightpreorder= Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rightinorder= Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right=dfs(rightpreorder,rightinorder);
        return root;
    }

    
}
