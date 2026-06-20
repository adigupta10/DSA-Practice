class Solution {
    public void swap(int x,int y,int[] nums){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
    public void reverse(int start,int end,int[] nums){
        while(start<=end){
            swap(start,end,nums);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
       int idx=-1;
       for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
       }
        if(idx!=-1){
            for(int j=n-1;j>idx;j--){
                if(nums[j]>nums[idx]){
                    swap(idx,j,nums);
                    break;
                }
            }
        }
        reverse(idx+1,n-1,nums);
    }
}