class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int currmax=0; int maxsum=nums[0];
        int currmin=0; int minsum=nums[0];
        for(int i : nums){
            currmax=Math.max(i,currmax+i);
            maxsum=Math.max(maxsum,currmax);

            currmin=Math.min(i,currmin+i);
            minsum=Math.min(minsum,currmin);

            total+=i;
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}