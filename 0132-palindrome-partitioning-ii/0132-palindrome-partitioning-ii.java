class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;     // 1 len String ex- "a" , "d" , "s" ;
        }
        //filling the boolean dp
        for(int L=2;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;
                if((s.charAt(i)==s.charAt(j)) && L==2){  //ex- "aa" ,"dd"
                    dp[i][j]=true;
                }
                else if(( s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                }
            }
        }
        // no. of cuts dp
        int[] t=new int[n];
        Arrays.fill(t,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(dp[0][i]==true){  // s[0...i] true hai => palindrome means no cuts
                t[i]=0;
            }
            else {
                for(int k=0;k<i;k++){
                    if(dp[k+1][i]==true  && 1 + t[k] < t[i]){
                        t[i]=t[k]+1;
                    }
                }
            }
        }
        return t[n-1];
    }
}