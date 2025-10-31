class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int c=1;
        int index=0;
        nums[index++]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(c<2 && nums[i]==nums[i-1]){
                c++;
                nums[index++]=nums[i];
            }
            else if(nums[i]!=nums[i-1]){
                c=1;
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}