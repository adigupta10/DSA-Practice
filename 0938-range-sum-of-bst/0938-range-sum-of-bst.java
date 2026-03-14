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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(root.val>=low && root.val<=high){
            return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }
        if(root.val<low) return rangeSumBST(root.right,low,high);
        return rangeSumBST(root.left,low,high);
    }
}


//visiting everynode O(n) 
//  int sum=0;
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         inorder(root,low,high);
//         return sum;
//     }
//     public void inorder(TreeNode root, int low, int high){
//         if(root==null) return;
//         inorder(root.left,low,high);
//         if(root.val>=low && root.val<=high) sum+=root.val;
//         inorder(root.right,low,high);
//     }


// //bfs solution
//         Queue<TreeNode> q=new LinkedList<>();
//         int sum=0;
//         q.add(root);
//         while(!q.isEmpty()){
//             TreeNode curr=q.poll();
//             if(curr==null) continue;
//             if(curr.val>=low && curr.val<=high){
//                 sum+=curr.val;
//             }
//             if(curr.val>low){
//                 q.offer(curr.left);
//             }
//             if(curr.val<high){
//                 q.offer(curr.right);
//             }
//         }
//         return sum;