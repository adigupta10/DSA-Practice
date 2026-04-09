class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        int count=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            count++; //every character is a palindrome
        }

        for(int L=2;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;
                
                if((s.charAt(i)==s.charAt(j)) && L==2 ){
                    dp[i][j]=true;
                    count++;
                }
                else if((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        count++;
                    }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return count;
    }
}