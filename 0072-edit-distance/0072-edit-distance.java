class Solution {
    static int[][] dp;
    public int minDistance(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        dp=new int[n][m];
        for(int[] x:dp) Arrays.fill(x,-1);
        return solve(0,0,w1,w2);
    }
    public static int solve(int i, int j, String w1, String w2){

        if(i>=w1.length()){
            return w2.length()-j;
        }
        if(j>=w2.length()){
            return w1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return solve(i+1,j+1,w1,w2);
        }
        int insert=1+solve(i,j+1,w1,w2);
        int del=1+solve(i+1,j,w1,w2);
        int repl=1+solve(i+1,j+1,w1,w2);

        return dp[i][j]=Math.min(insert,Math.min(del,repl));
    }
}