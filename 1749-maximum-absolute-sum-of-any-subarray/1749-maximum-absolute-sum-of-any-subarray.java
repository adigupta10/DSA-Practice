class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int x=kadaneMax(nums);
        int y=kadaneMin(nums);
        return Math.max(x,Math.abs(y));
    }
    public static int kadaneMax(int[] nums){
        int curr=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            maxi=Math.max(maxi,curr);
        }
        return maxi;
    }
    public static int kadaneMin(int[] nums){
        int curr=0;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            curr=Math.min(nums[i],curr+nums[i]);
            mini=Math.min(mini,curr);
        }
        return mini;
    }
}