class Solution {

    private void backtrack(int index,int[] nums,List<Integer> current, List<List<Integer>> l){
        l.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(i+1,nums,current,l);
            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),l);
        return l;
    }

}