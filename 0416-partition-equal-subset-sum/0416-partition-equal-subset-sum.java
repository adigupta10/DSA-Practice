class Solution {
    static Boolean[][] dp;
    public boolean canPartition(int[] arr) {
        //calculate total sum
        int sum=0;
        for(int x:arr) sum+=x;

        // s1 =s2 -> s1 + s2 =sum  -> s1=sum/2;   it is a subset problem which modified target(sum/2)  , we   have to find a single subset(s1) whose target(sum/2);

        if(sum%2!=0) return false;
        int target=sum/2;
        dp=new Boolean[arr.length][target+1];
        return solve(0,arr,target);
    }
     public static boolean solve(int i, int[] arr, int sum){
        
        if(sum==0) return true;
        if(i>=arr.length) return false;
        
        if(dp[i][sum]!=null) return dp[i][sum];
        
        boolean nottake=solve(i+1,arr,sum);
        boolean take=false;
        if(arr[i]<=sum){
            take=solve(i+1,arr,sum-arr[i]);
        }
        return dp[i][sum]=nottake || take;
    }
}