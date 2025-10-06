class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1) return false;
        int i=0;
        int j=1;
        int count=0;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                j++;
            }
            else{
                count++;
                i++;
                j++;
            }
        }
        return count<=k ? true : false;
    }
}