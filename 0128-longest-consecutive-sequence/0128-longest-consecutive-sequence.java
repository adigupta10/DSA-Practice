class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int count=1; int i=1; int maxcount=1;
        while(i<nums.length){
            if(nums[i]-nums[i-1]==1){
                count++;
            }
            else if(nums[i]==nums[i-1]){
                i++;
                continue;
            }
            else{
                maxcount=Math.max(maxcount,count);
                count=1;
            }
            i++;
        }
        maxcount=Math.max(maxcount,count);
        return maxcount;
    }
}