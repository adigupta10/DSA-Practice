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
    Integer prev=null;
    int mini=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return mini;
    }
    public int inorder(TreeNode root){
        if(root==null) return 0;
        inorder(root.left);

        if(prev!=null){
            mini=Math.min(mini,root.val-prev);
        }
        prev=root.val;
        inorder(root.right);

        return mini;
    }
}