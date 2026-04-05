class Solution {
    static int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        int x=dungeon.length;
        int y=dungeon[0].length;
        dp=new int[x][y];
        for(int[] t: dp) Arrays.fill(t,-1);
        int ans=solve(0,0,dungeon);
        return ans; 
    }
    public static int solve(int i,int j, int[][] dungeon){
        int n=dungeon.length;
        int m=dungeon[0].length;
        if(i>=n || j>=m ) return (int) 1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==n-1 && j==m-1){
            return dp[i][j]= (dungeon[i][j]>0 ? 1 : Math.abs(dungeon[i][j]) +1);
        }

        int right=solve(i,j+1,dungeon);
        int down=solve(i+1,j,dungeon);
        int req=Math.min(right,down);

       // or you can write this also
     //  int req = Math.min(right, down) - dungeon[i][j];
     //  return req<0 ? 1: req
        if(req>dungeon[i][j]){
            req-=dungeon[i][j];
        }
        else{
            req=1;
        }
        return dp[i][j] =req ;
    }
}