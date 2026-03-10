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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq=new ArrayDeque<>();
        int maxWidth=0;
        dq.offerFirst(new Pair(root,0));
        while(!dq.isEmpty()){
            int size=dq.size();
            int st=dq.peekFirst().idx;
            int ed=dq.peekLast().idx;
            maxWidth=Math.max(maxWidth,ed-st+1);
            while(size-->0){
                Pair p=dq.poll();
                TreeNode node=p.node;
                int idx=p.idx;
                if(node.left!=null) dq.offer(new Pair(node.left,idx*2+1));
                if(node.right!=null) dq.offer(new Pair(node.right,idx*2+2));
            }
        }
        return maxWidth;
    }
}