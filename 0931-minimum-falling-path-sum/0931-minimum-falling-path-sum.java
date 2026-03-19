class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int down = grid[i+1][j];
                int left = (j > 0) ? grid[i+1][j-1] : Integer.MAX_VALUE;
                int right = (j < n-1) ? grid[i+1][j+1] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(down, Math.min(left, right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, grid[0][j]);
        }
        return ans;
    }
}

// class Solution {
//     static int[][] dp;
//     public int minFallingPathSum(int[][] grid) {
//         int st=0;
//         int end=0;
//         int n=grid.length;
//         int ans=Integer.MAX_VALUE;
//         dp=new int[n][n];
//         for(int[] x:dp){
//             Arrays.fill(x,-1);
//         }
//         for(int j=0;j<n;j++){
//             ans=Math.min(ans,solve(st,j,grid));
//         }
//         return ans;
//     }
//     public static int solve(int i,int j,int[][] grid){
//         if(i>=grid.length || j<0 || j>=grid.length) return (int) 1e9;
//         if(i==grid.length-1) return grid[i][j];
//         if(dp[i][j]!=-1) return dp[i][j];
//         int down=solve(i+1,j,grid);
//         int left=solve(i+1,j-1,grid);
//         int right=solve(i+1,j+1,grid);
//         return dp[i][j]=grid[i][j] + Math.min(down,Math.min(left,right));
//     }
// }