class Solution {
    private void solve(int i,int[] candidates,int target,List<List<Integer>>ans,List<Integer> temp){
        if(i==candidates.length || target<0) return;
        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[i]);
        solve(i,candidates,target-candidates[i],ans,temp);
        temp.remove(temp.size()-1);
        solve(i+1,candidates,target,ans,temp);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,candidates,target,ans,temp);
        return ans;
    }
}