class Solution {
        int N;
        Double[][][] dp;
    private double solve(int r,int c,int k){
        if(r<0 || r>=N || c<0 || c>=N) return 0.0;
        if(k==0) return 1.0;
        if(dp[r][c][k] !=null) return dp[r][c][k];
        double result=0;
            result+=solve(r-2,c-1,k-1);
            result+=solve(r-2,c+1,k-1);
            result+=solve(r+2,c-1,k-1);
            result+=solve(r+2,c+1,k-1);
            result+=solve(r-1,c+2,k-1);
            result+=solve(r+1,c+2,k-1);
            result+=solve(r+1,c-2,k-1);
            result+=solve(r-1,c-2,k-1);

        return dp[r][c][k]=result/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        N=n;
        dp=new Double[n][n][k+1];
        return solve(row,column,k);
    }
}