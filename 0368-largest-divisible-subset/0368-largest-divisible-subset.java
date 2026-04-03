class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] prevIdx=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prevIdx,-1);

        int maxLen=1;
        int lastIdx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        prevIdx[i]=j;
                    }
                    if(dp[i]>maxLen){
                        maxLen=dp[i];
                        lastIdx=i;
                    }
                }
            }
        }
        ArrayList<Integer> l=new ArrayList<>();
        while(lastIdx!=-1){
            l.add(nums[lastIdx]);
            lastIdx=prevIdx[lastIdx];
        }
        return l;
    }
}