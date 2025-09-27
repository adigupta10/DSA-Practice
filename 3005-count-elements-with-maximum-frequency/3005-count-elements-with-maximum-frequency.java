class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];  // numbers are in range 1–100
        for (int i : nums) {
            freq[i]=freq[i]+1;
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<freq.length;i++){
            ans=Math.max(ans,freq[i]);
        }
        int res=0;
        for(int j=0;j<freq.length;j++){
            if(ans==freq[j]){
                res+=ans;
            }
        }
        return res;
    }
}