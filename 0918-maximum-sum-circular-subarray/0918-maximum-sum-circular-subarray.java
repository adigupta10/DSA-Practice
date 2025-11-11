class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //case-1
        int maxi=kadaneMaxSum(nums);
        //case-2
        int mini=kadaneMinSum(nums);
        //case-3
        int total=0;
        for(int j:nums) total+=j;
        if(maxi<0) return maxi;
        return Math.max(maxi,total-mini);
    }
    public int kadaneMaxSum(int[] nums){
        int curr=nums[0];
        int maxi=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            maxi=Math.max(maxi,curr);
        }
        return maxi;
    }
    public int kadaneMinSum(int[] nums){
        int curr=nums[0];
        int mini=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.min(nums[i],curr+nums[i]);
            mini=Math.min(mini,curr);
        }
        return mini;
    }
}