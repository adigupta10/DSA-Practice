class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] i: dp) Arrays.fill(i,-1);
       int ans=solve(coins,amount,0,dp);
       return ans;

    }
    public static int solve(int[] arr,int t, int i, int[][] dp){
        if(t==0){
            return 1;
        }
        if(t<0 || i>=arr.length) return 0;
        if(dp[i][t]!=-1) return dp[i][t];

        int l=solve(arr,t-arr[i],i,dp);
        int r=solve(arr,t,i+1,dp);

        return dp[i][t]=l+r;
    }
}