class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] arr=new int[n];
        int p=1;
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            p=p*nums[i-1];
            left[i]=p;
        }
        p=1;
        for(int j=n-2;j>=0;j--){
            p=p*nums[j+1];
            right[j]=p;
        }
        for(int k=0;k<n;k++){
            arr[k]=left[k]*right[k];
        }
        return arr;
    }
}