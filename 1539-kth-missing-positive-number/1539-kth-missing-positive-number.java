class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] ans=new int[1000+1001];
        for(int i=0;i<arr.length;i++){
            ans[arr[i]]++;
        }
        for(int j=1;j<ans.length;j++){
            if(ans[j]==0){
                k--;
            }
            if(k==0) return j;
        }
        return -1;
    }
}