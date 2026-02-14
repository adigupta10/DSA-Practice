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
    public void solve(TreeNode root,ArrayList<String> res,String temp){
        //root
        if(root==null) return;
        if(temp.length()==0){
            temp+=String.valueOf(root.val);
        }
        else{
            temp=temp+"->"+root.val;
        }
        if(root.left==null && root.right==null){
            res.add(temp);
            return;
        }
        solve(root.left,res,temp);
        solve(root.right,res,temp);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res=new ArrayList<>();
        if(root==null) return res;
        String temp="";
        solve(root,res,temp);
        return res;

    }
}