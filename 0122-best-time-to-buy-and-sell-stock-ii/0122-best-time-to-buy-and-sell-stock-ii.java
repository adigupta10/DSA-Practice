class Solution {
    static int[][] dp;
    public int maxProfit(int[] arr) {
    //    buy==0 and sell==1
    int n=arr.length;
    dp=new int[n][2];
    for(int[] x:dp) Arrays.fill(x,-1);
        int ans=solve(0,0,arr);
        return ans;
    }
    public static int solve(int curr, int state, int[] arr){
        if(curr>=arr.length) return 0;
        if(dp[curr][state]!=-1) return dp[curr][state];
        int take=0;
        if(state==0){
            take=Math.max(
                -arr[curr] + solve(curr+1,1,arr),
                    0 +     solve(curr+1,0,arr) );
        }
        else{
            take=Math.max(
                arr[curr] + solve(curr+1,0,arr),
                  0 +       solve(curr+1,1,arr)  );
        }
        return dp[curr][state]=take;
    }
}