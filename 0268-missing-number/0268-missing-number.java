class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        int sum=0;
        for(int i=0;i<=n;i++){
            totalSum+=i;
        }
        for(int j:nums){
            sum+=j;
        }
        return totalSum-sum;
    }
}