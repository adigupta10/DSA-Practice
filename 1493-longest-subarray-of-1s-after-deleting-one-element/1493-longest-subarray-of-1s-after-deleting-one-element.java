class Solution {
    public int longestSubarray(int[] nums) {
        int k=1; int j=0;
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) k--;
            while(k<0){
                if(nums[j]==0){
                    k++;
                }
                j++;           
            }
            maxi=Math.max(maxi,i-j);
        }
        return maxi;
    }
}