class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Long> seen=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long needed=(long) target-nums[i]-nums[j]-nums[k];
                    if(seen.contains(needed)){
                        List<Integer> quad=Arrays.asList(nums[i],nums[j],nums[k],(int)needed);
                        Collections.sort(quad);
                        set.add(quad);
                    }
                    seen.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}