class Solution {
    static int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new int[n][m];
        for(int[] x:dp) Arrays.fill(x,-1);
        return solve(0,0,s1,s2);  
    }
    public static int solve(int i ,int j,String s1,String s2){
        if(i>=s1.length() || j>=s2.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
           return 1+ solve(i+1,j+1,s1,s2);
        }
        return dp[i][j]=Math.max(solve(i+1,j,s1,s2),solve(i,j+1,s1,s2));
    }
}