class Solution {
    static int n;
    static int[][] dp;
    public int minCut(String s) {
        n=s.length();
        dp=new int[n][n];
        for(int[]x:dp) Arrays.fill(x,-1);
        return solve(0,n-1,s);
    }
    public static int solve(int i,int j,String s){
        //base case
        if(i>=n) return 0;
        if(isPal(i,j,s)) return dp[i][j]=0;

        if(dp[i][j]!=-1) return dp[i][j];

        int mini=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(isPal(i,k,s)){
                int cuts =1+ solve(k+1,j,s);
                mini=Math.min(mini,cuts);
            }  
        }
        return dp[i][j]=mini;
    }
    public static boolean isPal(int i,int j,String s){
        if(i>j) return true;

        if(s.charAt(i)==s.charAt(j)) return isPal(i+1,j-1,s);

        return false;
    }
}