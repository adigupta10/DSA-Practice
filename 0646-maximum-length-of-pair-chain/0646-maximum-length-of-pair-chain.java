class Solution {
    static int[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> a[1]-b[1]);
        int n=pairs.length;
        dp=new int[n][n+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        int ans=solve(0,-1,pairs);
        return ans;
    }
    public static int solve(int curr, int prev,int[][] pairs){
        if(curr>=pairs.length) return 0;
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        int taken=0;
        if(prev==-1 || pairs[curr][0]>pairs[prev][1]){
            taken=1+solve(curr+1,curr,pairs);
        }
        int nottaken=solve(curr+1,prev,pairs);

        return dp[curr][prev+1]=Math.max(taken,nottaken);
    }
}