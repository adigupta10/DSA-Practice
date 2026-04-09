class Solution {
    static int n;
    static int[][] dp;
    public int minInsertions(String s) {
        n=s.length();
        dp=new int[n][n];
        for(int[] x:dp) Arrays.fill(x,-1);
        return solve(0,n-1,s);
    }
    public static int solve(int i,int j,String s){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return solve(i+1,j-1,s);
        }
        int insert= Math.min(1+solve(i+1,j,s),1+solve(i,j-1,s));
        return dp[i][j]=insert;
    }
}