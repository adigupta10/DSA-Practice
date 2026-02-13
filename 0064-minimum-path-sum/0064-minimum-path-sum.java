class Solution {
    static int[][] dp;
    public int solve(int i,int j,int n,int m,int[][] grid){
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1) return grid[i][j];
        
        if(dp[i][j]!=-1) return dp[i][j];

        int downsum=solve(i,j+1,n,m,grid);
        int rightsum=solve(i+1,j,n,m,grid);

        return dp[i][j]=grid[i][j]+Math.min(downsum,rightsum);
    }

    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        int ans=solve(0,0,n,m,grid);
        return ans;
    }
}