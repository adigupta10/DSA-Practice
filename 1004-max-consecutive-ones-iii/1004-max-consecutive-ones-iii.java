class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val=k;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    if(val>0) val--;
                    else break;
                }
                maxi=Math.max(maxi,j-i+1);
            }
        }
        return maxi!=Integer.MIN_VALUE ? maxi : 0;
    }
}