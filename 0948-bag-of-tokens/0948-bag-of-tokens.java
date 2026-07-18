class Solution {
    public int bagOfTokensScore(int[] arr, int p) {
        int maxi=0;
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int ans=0;
        while(i<=j){
            if(arr[i]<=p){
                p-=arr[i];
                i++;
                ans++;
                maxi=Math.max(maxi,ans);
            }
            else{
                ans--;
                if(ans<0) return 0;
                p+=arr[j];
                j--;
            }
        }
        return maxi;
    }
}