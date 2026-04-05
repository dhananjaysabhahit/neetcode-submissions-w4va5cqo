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
    int cnt=1;
    int arr[]; 
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp=new int[]{0,0};
        dfs(root,tmp,k);
        return tmp[1];
    }

    void dfs(TreeNode root, int[] arr,int k){
        if(root==null) return;
        if(root.left!=null) dfs(root.left,arr,k);
        arr[0]++;
        if(arr[0]==k){
            arr[1] = root.val;
            return; 
        }
        if(root.right!=null) dfs(root.right,arr,k);
    }
}
