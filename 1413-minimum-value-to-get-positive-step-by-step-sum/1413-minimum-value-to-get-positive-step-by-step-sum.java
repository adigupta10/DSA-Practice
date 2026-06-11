class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum=new int[nums.length];
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==0) prefixSum[i]=nums[i];
            else prefixSum[i]=prefixSum[i-1] + nums[i];
            mini=Math.min(mini,prefixSum[i]);
        }
        return mini>=1 ? 1 : Math.abs(mini)+1;
    }
}