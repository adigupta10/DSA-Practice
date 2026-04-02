class Solution {
    public int maximalSquare(char[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int maxi=0;
       int[][] dp=new int[n+1][m+1];
       for(int i=n-1;i>=0;i--){
        for(int j=m-1;j>=0;j--){
            if(mat[i][j]=='0'){
                dp[i][j]=0;
            }
            else{
                dp[i][j]=1+Math.min(dp[i][j+1],Math.min(dp[i+1][j+1],dp[i+1][j]));
                maxi=Math.max(maxi,dp[i][j]);
            }
        }
       }
       return maxi*maxi; 
    }
}