class Solution {
    public int findMiddleIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int leftsum=solve(nums,0,i-1);
            int rightsum=solve(nums,i+1,nums.length-1);
            if(leftsum==rightsum) return i;
        }
        return -1; 
    }
    public static int solve(int[] nums,int l,int r){
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=nums[i];
        }
        return sum;
    }
}