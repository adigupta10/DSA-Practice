class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] ps=new long[nums.length];
        ps[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ps[i]=ps[i-1]+nums[i];
        } 
        long maxSum=Long.MIN_VALUE;
        for(int i=0;i<k;i++){
            int st=i;
            long currSum=0;
            while(st<nums.length && st+k-1 < nums.length){
                int j=st+k-1;
                long newps=ps[j]-((st>0) ? ps[st-1] : 0);
                currSum=Math.max(newps,currSum+newps);
                maxSum=Math.max(maxSum,currSum);
                st+=k;
            }
        }
        return maxSum;
    }
}