class Solution {
    static int maxi=0;
    static int[][] dp;
    public int longestStrChain(String[] words) {
       int n=words.length;
       Arrays.sort(words,(a,b)-> a.length()-b.length());
       dp=new int[n][n+1];
       for(int[] x: dp){
        Arrays.fill(x,-1);
       }
       int ans=solve(0,-1,words);
       return ans;
    }
    public static int solve(int curr,int prev,String[] words){
        if(curr>=words.length) return 0;

        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];

        int taken=0;
        if(prev==-1 || isPre(words[prev],words[curr])){
            taken=1+ solve(curr+1,curr,words);
        }
        int nottaken=solve(curr+1,prev,words);
        return dp[curr][prev+1]=Math.max(taken,nottaken);
    }
    public static boolean isPre(String x, String y){
        int p=x.length();
        int q=y.length();
        if((q-p)!=1) return false;
        int i=0; int j=0;
        while(i<p && j<q){
            if(x.charAt(i)==y.charAt(j)){
                i++;
            }
            j++;
        }
        return i==p;
    }
}

