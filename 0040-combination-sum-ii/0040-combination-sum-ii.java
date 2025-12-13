class Solution {
    private void solve(int i,int[] candidates,int target,List<List<Integer>>ans,List<Integer> temp){
        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==candidates.length || target<0) return;
        //do
        temp.add(candidates[i]);
        //explore
        solve(i+1,candidates,target-candidates[i],ans,temp);
        //undo
        temp.remove(temp.size()-1);
        //skip
        while(i<candidates.length-1 && candidates[i]==candidates[i+1]){
            i++;
        }
        solve(i+1,candidates,target,ans,temp);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,candidates,target,ans,temp);
        return ans;
    }
}