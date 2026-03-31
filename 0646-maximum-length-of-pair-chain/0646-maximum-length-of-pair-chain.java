class Solution {
    public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs,(a,b)-> Integer.compare(a[1],b[1]));
      int n=pairs.length;
      int[] dp=new int[n];
      Arrays.fill(dp,1);
      int maxi=1;
      for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(pairs[i][0]>pairs[j][1]){
                dp[i]=Math.max(dp[i],dp[j]+1);
                maxi=Math.max(dp[i],dp[j]);
            }
        }
      }
      return maxi;  
    }
}