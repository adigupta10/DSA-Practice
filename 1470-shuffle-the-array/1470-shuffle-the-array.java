class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i=0; int j=n;
        int[] arr=new int[n*2];
        int idx=0;
        while(i<n && j<2*n){
            arr[idx++]=nums[i];
            arr[idx++]=nums[j];
            i++;
            j++;
        }
        return arr;
    }
}