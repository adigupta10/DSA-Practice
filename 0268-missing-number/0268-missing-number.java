class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=1; int arr=0;
        int flag=0;
        if(nums.length==1) return 0;
        while(i<nums.length){
            if((nums[i]-nums[i-1])!=1){
                arr=nums[i]-1;
                flag=1;
                break;
            }
            i++;
        }
        return flag==0 ? nums[i-1]+1 : arr;
    }
}