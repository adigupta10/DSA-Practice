class Solution {
    static int[][] dp;
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int[] x:dp) Arrays.fill(x,-1);
        int ans=solve(0,0,n,m,grid);
        return ans;
    }

     public static int solve(int i, int j, int n , int m,int[][] grid){
        if(i>=n || j>=m) return (int)1e9;
        if(i==n-1 && j==m-1){
            return dp[i][j]=grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int right= grid[i][j] +solve(i,j+1,n,m,grid);
        int down= grid[i][j] +solve(i+1,j,n,m,grid);
        return dp[i][j]= Math.min(right,down);

    }
}