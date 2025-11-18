class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        if(n==1 && nums[0]==0) return 0;
        if(nums[0]==1 && n==1) return 1;
        int i=0;
        int maxi=0;
        int c=0;
        while(i<n){
            if(nums[i]==1){
                c++;
                i++;
                maxi=Math.max(maxi,c);
                continue;
            }
            else{
                maxi=Math.max(maxi,c);
                c=0;
            }
            i++;
        }
        return maxi;
    }
}