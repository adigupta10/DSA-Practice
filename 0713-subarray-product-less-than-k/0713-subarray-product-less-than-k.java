class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0; // worst cond nums={1} and product =1 which is not <k

        int count=0;
        int left=0;
        int right=0;
        int p=1;
        while(right<nums.length){
            p*=nums[right];
            while(p>=k){
                p/=nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}