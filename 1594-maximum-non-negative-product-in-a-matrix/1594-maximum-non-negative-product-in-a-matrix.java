class Solution {
    static int n;
    static int m;
    static class Pair{
        long max;
        long min;
        Pair(long max,long min){
            this.max=max;
            this.min=min;
        }
    }
    static Pair[][] dp;
    static long mod=1000000007L;
    public int maxProductPath(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new Pair[n][m];
        Pair res=solve(0,0,grid);
        long maxi=Math.max(res.max,res.min);
        return maxi<0 ? -1 :(int) (maxi%mod);
    }
    public static Pair solve(int i,int j,int[][] grid){

        if(i>=n || j>=m) return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE);

        if(i==n-1 && j==m-1) return new Pair(grid[i][j],grid[i][j]);

        if(dp[i][j]!=null) return dp[i][j];

        Pair right=solve(i,j+1,grid);
        Pair down=solve(i+1,j,grid);

        long maxval=Integer.MIN_VALUE;
        long minval=Integer.MAX_VALUE;

        if(right.max!=Integer.MIN_VALUE){
            maxval=Math.max(maxval,Math.max(   (right.max*grid[i][j]), (right.min*grid[i][j])  ) );
            minval=Math.min(minval,Math.min(   (right.max*grid[i][j]), (right.min*grid[i][j])  ) );
        }
        if(down.max!=Integer.MIN_VALUE){
            maxval=Math.max(maxval,Math.max(   (down.max*grid[i][j]), (down.min*grid[i][j])  ) );
            minval=Math.min(minval,Math.min(   (down.max*grid[i][j]), (down.min*grid[i][j])  ) );
        }
        return dp[i][j]=new Pair(maxval,minval);
    }
}