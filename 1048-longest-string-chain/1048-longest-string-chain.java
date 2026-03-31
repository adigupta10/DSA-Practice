class Solution {
    public int longestStrChain(String[] words) {
       Arrays.sort(words,(a,b)-> a.length()-b.length());
       int n=words.length;
       int maxi=1;
       int[] dp=new int[n];
       Arrays.fill(dp,1);
       for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPre(words[j],words[i])){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        maxi=Math.max(maxi,dp[i]);
                    }
                }
            }
        }
        return maxi;
    }
    public static boolean isPre(String x, String y){
        int p=x.length();
        int q=y.length();
        if((q-p)!=1) return false;
        int i=0; int j=0;
        while(i<p && j<q){
            if(x.charAt(i)==y.charAt(j)){
                i++;
            }
            j++;
        }
        return i==p;
    }
}

