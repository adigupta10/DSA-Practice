class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        int k=1;
        int maxi=0;
        while(right<nums.length){
            if(nums[right]==0){
                k--;
            }
            while(k<0){
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
            maxi=Math.max(maxi,right-left);
            right++;
        }
        return maxi;
    }
}