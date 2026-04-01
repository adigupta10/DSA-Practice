class Solution {
    static int[][] dp;
    public int maxProfit(int[] arr,int fee) {
        // buy==0 and sell==1
        int n=arr.length;
        dp=new int[n][2];
        for(int[] x: dp) Arrays.fill(x,-1);
        int ans=solve(0,0,arr,fee);
        return ans;
    }
public static int solve(int curr, int state, int[] arr,int fee){
    if(curr>=arr.length) return 0;
    if(dp[curr][state]!=-1) return dp[curr][state];
    int profit=0;
    if(state==0){
        profit=Math.max(
            -arr[curr] + solve(curr+1,1,arr,fee),
                0 +     solve(curr+1,0,arr,fee) );
    }
    else{
        profit=Math.max(
            arr[curr]-fee + solve(curr+1,0,arr,fee),
                0 +     solve(curr+1,1,arr,fee) );
    }
    return dp[curr][state]=profit;
    }
}