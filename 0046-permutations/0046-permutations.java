class Solution {
    public static void solve(List<List<Integer>> ans, List<Integer> temp, HashSet<Integer> set,int[] nums){
        //base case
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(i)){
                continue;
            }
            temp.add(nums[i]);
            set.add(i);
            solve(ans,temp,set,nums);
            temp.remove(temp.size()-1);
            set.remove(i);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        solve(ans,temp,set,nums);
        return ans;
    }
}