class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int a=solve(coins,amount , dp);
        return a;
    }
    public static int solve(int[] arr,int amt,int[] dp){
        if(amt==0) return 0;
        if(amt<0) return -1;
        if(dp[amt]!=0) return dp[amt];
        int mini=Integer.MAX_VALUE;
        for(int i : arr){
            int res=solve(arr,amt-i,dp);
            if(res>=0 && res<mini){
                mini=res+1;
            }
        }
        dp[amt]=(mini==Integer.MAX_VALUE) ? -1: mini;
        return dp[amt];
    }
}