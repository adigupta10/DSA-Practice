class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=1; int n=nums.length;
        if(nums[0]!=0) return 0;
        while(i<nums.length){
            if((nums[i]-nums[i-1])!=1){
                return nums[i-1]+1;
            }
            i++;
        }
        return n;
    }
}