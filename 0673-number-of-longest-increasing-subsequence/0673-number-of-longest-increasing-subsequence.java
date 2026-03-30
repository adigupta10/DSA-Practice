class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                }
            }
        }
        int maxi=0;
        for(int i:dp) maxi=Math.max(maxi,i);
        int ans=0;
        for(int d=0;d<n;d++){
            if(dp[d]==maxi) ans+=count[d];
        }
        return ans;
    }
}
