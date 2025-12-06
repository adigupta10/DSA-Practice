class Solution {

    private void allsubset(int[] nums , int i,List<Integer> temp,List<List<Integer>> ans){
        //base case
        int n=nums.length;
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        //do
        temp.add(nums[i]);
        //explore
        allsubset(nums,i+1,temp,ans);
        //backtrack
        temp.remove(temp.size()-1);
        allsubset(nums,i+1,temp,ans);  
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        allsubset(nums,0,temp ,ans);
        return ans;
    }
}