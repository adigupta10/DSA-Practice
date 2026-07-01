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
            if(k==0){
                maxi=Math.max(maxi,right-left);
            }
            else{
                maxi=Math.max(maxi,right-left+1);
            }
            right++;
        }
        if(k==1 && maxi!=0){
            return  maxi-1;
        }
        return maxi;
    }
}