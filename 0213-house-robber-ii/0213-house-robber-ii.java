class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        if(n==1) return nums[0];
        int firsthouse=solve(nums,0,n-1);
        Arrays.fill(dp,-1);
        int secondhouse=solve(nums,1,n);
        return Math.max(firsthouse,secondhouse);
    }
    public static int solve(int[] nums,int i,int size){
        if(i>=size) return 0;
        if(dp[i]!=-1) return dp[i];
        int notpick=solve(nums, i+1,size);
        int pick= nums[i] + solve(nums,i+2,size);

        return dp[i]=Math.max(pick,notpick);
    }
}