class Solution {
    public int[] rearrangeArray(int[] nums) {
        int odd=1;
        int even=0;
        int[] arr=new int[nums.length];
        for(int x:nums){
            if(x<0){
                arr[odd]=x;
                odd+=2;
            }
            else{
                arr[even]=x;
                even+=2;
            }
        }
        return arr;
    }
}