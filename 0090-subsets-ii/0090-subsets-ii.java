class Solution {
    private void back(int[] nums,int i,List<List<Integer>> ans,List<Integer> temp){
        int n=nums.length;
        //base case
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // do
        temp.add(nums[i]);
        //explore 
        back(nums,i+1,ans,temp);
        //check duplicates
        while(i<n-1 && nums[i]==nums[i+1]){
            i++;
        }
        //undo
        temp.remove(temp.size()-1);
        back(nums,i+1,ans,temp);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        back(nums,0,ans,temp);
        return ans;
    }
}