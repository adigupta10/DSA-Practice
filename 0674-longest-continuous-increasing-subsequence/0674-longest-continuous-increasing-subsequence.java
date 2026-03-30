class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int left=1;
        int ct=1;
        int maxi=1;
        while(left<nums.length){
            if(nums[left]>nums[left-1]) ct++;
            else{
                ct=1;
            }
            maxi=Math.max(maxi,ct);
            left++;
        }
        return maxi;
    }
}