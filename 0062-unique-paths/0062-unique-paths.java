class Solution {
    static int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[n][m];
        for(int[] x:dp) Arrays.fill(x,-1);
        int ans=solve(0,0,n,m);
        return ans;
    }
    public static int solve(int i, int j, int n , int m){
        if(i>=n || j>=m) return 0;
        if(i==n-1 && j==m-1) return dp[i][j]=1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(i,j+1,n,m);
        int down=solve(i+1,j,n,m);

        return dp[i][j]=right+down;
    }
}