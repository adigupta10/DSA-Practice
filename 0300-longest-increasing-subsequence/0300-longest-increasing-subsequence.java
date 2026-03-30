class Solution {
    static int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        int ans=solve(0,-1,nums);
        return ans;
    }
    public int solve(int i, int prev, int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int notPick=solve(i+1,prev,nums);
        int pick=0;
        if(prev==-1 || nums[prev]<nums[i]){
            pick=1+ solve(i+1,i,nums);
        }
        return dp[i][prev+1]=Math.max(pick,notPick);
    }
}