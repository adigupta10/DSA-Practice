class Solution {
    static int[][] dp;
    public static int solve(int i, int j, int[][] mat){
        if(i>=mat.length || j>=mat[0].length) return 0;

        if(mat[i][j]==0) return dp[i][j]=0;

        if(dp[i][j]!=-1) return dp[i][j];

        int right=solve(i,j+1,mat);
        int dia=solve(i+1,j+1,mat);
        int down=solve(i+1,j,mat);

        int ans=1+Math.min(right,Math.min(dia, down));
        return dp[i][j]=ans;
    }
    public int countSquares(int[][] mat) {
        int sum=0;
        int n=mat.length;
        int m=mat[0].length;
        dp=new int[n][m];
        for(int[]x:dp) Arrays.fill(x,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=solve(i,j,mat);
            }
        }
        return sum;
    }
}
