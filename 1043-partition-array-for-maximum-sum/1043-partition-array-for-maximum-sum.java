class Solution {
    static int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(0,arr,k);
    }
    public static int solve(int i, int[] arr,int k){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxcost=Integer.MIN_VALUE;
        int total=0;
        int ans=0;
        for(int j=i;j<arr.length;j++){
            if(j-i+1 <= k){
                maxcost=Math.max(maxcost,arr[j]);
                total=maxcost * (j-i+1) + solve(j+1,arr,k);
                ans=Math.max(ans,total);
            }
        }
        return dp[i]=ans;
    }
}