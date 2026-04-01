class Solution {
    static int[][][] dp;
    public int maxProfit(int k, int[] arr) {
        // 1-> buy and 0->sell
        int n=arr.length;
        dp=new int[n][2][k+1];
        for(int[][] mat:dp){
            for(int[] x :mat) Arrays.fill(x,-1);
        }

        int ans=solve(0,1,arr,k);
        return ans;
    }
    public static int solve(int curr, int state, int[] arr, int k){
        if(curr>=arr.length || k==0 ) return 0;

        if(dp[curr][state][k]!=-1) return dp[curr][state][k];
        int profit=0;
        if(state==1){  // buy
            profit=Math.max(
                -arr[curr] + solve(curr+1,0,arr,k),
                0          + solve(curr+1,1,arr,k) );
        }
        if(state==0){  // sell
            profit= Math.max(
               arr[curr] + solve(curr+1,1,arr,k-1),
                0          + solve(curr+1,0,arr,k) );
        }
        return dp[curr][state][k]=profit;
    }
}