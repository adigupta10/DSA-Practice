class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[m+n];
        int index=0;
        for(int i=0;i<n;i++){
            arr[index++]=nums1[i];
        }
        for(int j=0;j<m;j++){
            arr[index++]=nums2[j];
        }
        if(arr.length==1) return arr[0];
        Arrays.sort(arr);
        double ans=0;
        if(arr.length%2!=0) {
            ans=arr[(arr.length-1)/2];
        }
        int f=0;
        if(arr.length%2==0){
            f=arr[arr.length/2] + arr[(arr.length/2)-1] ;
            ans=(double)f/2;
        }
        return ans;
    }
}