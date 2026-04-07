class Solution {
    static int[][] dp;
    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        int[] arr=new int[len+2];
        arr[0]=0;
        int idx=1;
        for(int i:cuts){
            arr[idx++]=i;
        }
        arr[idx]=n;
        Arrays.sort(arr);
        dp=new int[arr.length][arr.length];

        for(int[] x:dp) Arrays.fill(x,-1);
        return solve(0,arr.length-1,arr);
    }
    public static int solve(int l ,int r,int[] arr){

        if(r-l<2) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int mini=Integer.MAX_VALUE;
        for(int k=l+1;k<=r-1;k++){
            int cost=(arr[r]-arr[l])+solve(l,k,arr) + solve(k,r,arr);
            mini=Math.min(mini,cost);
        }
        return dp[l][r]=mini;
    }
}