class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> ans=new HashSet<>();
        ArrayList<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        solve(0,-1,temp,ans,nums);
        for(List x: ans){
            res.add(new ArrayList<>(x));
        }
        return res;
    }
    public static void solve(int curr, int prev, ArrayList<Integer> temp,Set<List<Integer>> ans,int[] nums){
        if(curr>=nums.length){
            if(temp.size()>=2){
                ans.add(new ArrayList<>(temp));
            }
            return ;
        }
        if(prev==-1 || nums[curr]>=nums[prev]){
            temp.add(nums[curr]);
           solve(curr+1,curr,temp,ans,nums); 
            temp.remove(temp.size()-1);
        }
        solve(curr+1,prev,temp,ans,nums);
    }
}