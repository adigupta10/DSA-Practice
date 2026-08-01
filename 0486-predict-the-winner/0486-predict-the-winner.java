class Solution {
    static int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int total=0;
        int n=nums.length;
        dp=new int[n+1][n+1];
        for(int[] x: dp) Arrays.fill(x,-1);
        for(int i=0;i<nums.length;i++) total+=nums[i];
        int p1=solve(0,n-1,nums);
        int p2=total-p1;
        return p1>=p2;
    }
    public static int solve(int i,int j,int[] nums){
        if(i>j) return 0;
        if(i==j) return dp[i][j]=nums[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int take_i=nums[i] + Math.min(solve(i+1,j-1,nums),solve(i+2,j,nums));
        int take_j=nums[j] + Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums));

        return dp[i][j]=Math.max(take_i,take_j);
    }
}