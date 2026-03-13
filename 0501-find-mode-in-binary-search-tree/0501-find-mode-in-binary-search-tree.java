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
    public int[] findMode(TreeNode root) {
        int count=1;
        int maxi=0;
        if(root==null) return new int[]{0};
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        solve(root,l);
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int d:l){
            set.add(d);
            int freq=map.getOrDefault(d,0)+1;
            map.put(d,freq);
            maxi=Math.max(freq,maxi);
        }
        for(int key:set){
            if(maxi==map.get(key)){
                res.add(key);
            }
        }
        if(res.size()==0) return new int[]{};
        int[] arr=new int[res.size()];
        int index=0;
        for(int list:res){
            arr[index++]=list;
        }
        return arr;
        
    }
    public void solve(TreeNode root,ArrayList<Integer> l){
        if(root==null) return;
        solve(root.left,l);
        l.add(root.val);
        solve(root.right,l);
    }
}