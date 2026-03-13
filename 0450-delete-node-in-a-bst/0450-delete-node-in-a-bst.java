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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            // single child and leaf child
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            // double child
            // left jao ya right jao
            TreeNode node=findSuccessor(root.right);
            // data change kardo
            root.val=node.val;
            //ab find karke delete kar do
            root.right=deleteNode(root.right,node.val);
            }
        return root;
    }
    public TreeNode findSuccessor(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
}