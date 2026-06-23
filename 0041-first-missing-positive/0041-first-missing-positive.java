class Solution {
    public int firstMissingPositive(int[] nums) {
        int j=0;
        int n=nums.length;
        while(j<nums.length){
            int correctidx=nums[j]-1;
            if((nums[j]>0 && nums[j]<=n ) && nums[j]!=nums[correctidx]){
                int temp=nums[j];
                nums[j]=nums[correctidx];
                nums[correctidx]=temp;
            }
            else{
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}