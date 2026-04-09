class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int maxLen=1;
        int idx=0;
        for(int i=0;i<n;i++){   //diagonal elements
            dp[i][i]=true;
        }
        for(int L=2;L<=n;L++){
            for(int i=0; i+L-1<n;i++){
                int j=i+L-1;

                if((s.charAt(i)==s.charAt(j)) && L==2 ) {
                    dp[i][j]=true;
                    maxLen=2;
                    idx=i;
                }
                //more than 2 len
                else if((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]==true ){
                    dp[i][j]=true;
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        idx=i;
                    }
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return s.substring(idx,idx+maxLen);
    }
}