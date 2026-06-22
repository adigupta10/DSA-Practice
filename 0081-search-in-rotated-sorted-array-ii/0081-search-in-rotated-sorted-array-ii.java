class Solution {
    public boolean search(int[] arr, int t) {
       // take this example {1,3,1,1};
       int l=0,h=arr.length-1;
       while(l<=h){
        int mid=l+(h-l)/2;
        if(arr[mid]==t) return true;
        if(arr[mid]==arr[l] && arr[mid]==arr[h]){
            l++;
            h--;
            continue;
        }
        //left part is sorted
        if(arr[l]<=arr[mid]){
            if(arr[l]<=t && t<arr[mid]){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        //right part is sorted
        else{
            if(arr[mid]<t && t<=arr[h]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
       }
       return false;
    }
}