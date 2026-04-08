class Solution {
    static int[][] dp;
    public int countSubstrings(String s) {
        int count=0;
        int n=s.length();
        dp=new int[n][n];
        for(int[] x:dp) Arrays.fill(x,-1);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)) count++;
            }
        }
        return count;
    }
    public static boolean isPalindrome(int i,int j,String s){
        if(i>j) return true;
        if(dp[i][j]!=-1){
            if(dp[i][j]==1) return true;
            else return false;
        }
        if(s.charAt(i)==s.charAt(j)){
            boolean temp=isPalindrome(i+1,j-1,s);
            dp[i][j]= temp==true ? 1 : 0;
            return temp;
        }
        dp[i][j]=0;
        return false;
    }
}