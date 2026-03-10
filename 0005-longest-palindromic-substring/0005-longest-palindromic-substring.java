class Solution {
    String ans="";
    int[][] dp;
    boolean solve(String s,int i,int j){
      if(i>=j) return true;
      if(dp[i][j]!=-1) return dp[i][j]==1;
      if(s.charAt(i)==s.charAt(j)){
        if(solve(s,i+1,j-1)){
            dp[i][j]=1;
            return true;
        }
      }
      dp[i][j]=0;
      return false;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        dp=new int[n][n];
        int len=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j)){
                    if(j-i+1>len){
                        len=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}