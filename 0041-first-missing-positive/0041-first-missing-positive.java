class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=1;
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}