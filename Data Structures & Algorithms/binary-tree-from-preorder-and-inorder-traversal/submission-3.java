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
        return dfs(Arrays.stream(preorder).boxed().toList(),Arrays.stream(inorder).boxed().toList());
    }

    public TreeNode dfs(List<Integer> preorder,List<Integer> inorder){
        //approach 1
        // if(l>r) return null;
        // int mid=idxmap.get(preorder[idx]);
        // TreeNode root = new TreeNode(preorder[idx]);
        // idx++;
        // root.left=dfs(preorder,l,mid-1);
        // root.right=dfs(preorder,mid+1,r);
        
        // return root;
        //approach 2
        if(preorder.size()==0 || inorder.size()==0)
            return null;
        int rootval=preorder.get(0);
        TreeNode root = new TreeNode(rootval);
        int mid=inorder.indexOf(rootval);

        root.left=dfs(preorder.subList(1,mid+1),inorder.subList(0,mid));
        root.right=dfs(preorder.subList(mid+1,preorder.size()),inorder.subList(mid+1,inorder.size()));
        return root;
    }

    
}
