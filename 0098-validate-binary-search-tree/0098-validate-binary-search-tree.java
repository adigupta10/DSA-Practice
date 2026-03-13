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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        if(root.left!=null && findMax(root.left)>=root.val) return false;
        if(root.right!=null && findMin(root.right)<=root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
    public static int findMax(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    }
    public static int findMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }
}