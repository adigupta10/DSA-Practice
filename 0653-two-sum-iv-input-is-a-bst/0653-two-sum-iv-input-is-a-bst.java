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
    HashSet<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);

        if(findTarget(root.left,k)) return true;
        if(findTarget(root.right,k)) return true;
        return false;
    }
    
}
//using hashset
// using arraylist and two pointer
//bruteforce code
// class Solution {

//     public boolean findTarget(TreeNode root, int k) {
//         return traverse(root, root, k);
//     }

//     // outer traversal
//     private boolean traverse(TreeNode root, TreeNode curr, int k) {
//         if (curr == null)
//             return false;

//         // search for complement in whole tree
//         if (search(root, curr, k - curr.val))
//             return true;

//         return traverse(root, curr.left, k) ||
//                traverse(root, curr.right, k);
//     }

//     // search value in BST
//     private boolean search(TreeNode root, TreeNode curr, int val) {
//         if (root == null)
//             return false;

//         if (root.val == val && root != curr)
//             return true;

//         if (val < root.val)
//             return search(root.left, curr, val);
//         else
//             return search(root.right, curr, val);
//     }
//}