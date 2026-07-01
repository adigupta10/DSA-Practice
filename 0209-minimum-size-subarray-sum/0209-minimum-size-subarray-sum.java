class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int mini=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];
            while(left<=right && sum>=target ){
                mini=Math.min(mini,right-left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return mini==Integer.MAX_VALUE ? 0 : mini;
    }
}