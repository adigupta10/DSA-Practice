class Solution {
    static int[][] dp;
    public boolean stoneGame(int[] piles) {
         int sum=0;
         int n=piles.length;
         dp=new int[n+1][n+1];
         for(int[] x:dp) Arrays.fill(x,-1);
         for(int x:piles) sum+=x;
         int alice=solve(piles,0,n-1);
         return alice>sum/2;
    }
    public static int solve(int[] piles,int i,int j){
        if(i>j) return 0;
        if(i==j) return dp[i][j]=piles[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int take_i=piles[i] + Math.min(solve(piles,i+2,j),solve(piles,i+1,j-1));
        int take_j=piles[j] + Math.min(solve(piles,i,j-2),solve(piles,i+1,j-1));

        return dp[i][j]=Math.max(take_i,take_j);
    }
}