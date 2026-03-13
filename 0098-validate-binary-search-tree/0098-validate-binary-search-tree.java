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
        ArrayList<Integer> l=new ArrayList<>();
        solve(root,l);
        for(int i=1;i<l.size();i++){
           if(l.get(i)<=l.get(i-1)){
            return false;
           }
        }
        return true;
    }
    public void solve(TreeNode root,ArrayList<Integer> l){
        if(root==null) return;
        solve(root.left,l);
        l.add(root.val);
        solve(root.right,l);
    }
}