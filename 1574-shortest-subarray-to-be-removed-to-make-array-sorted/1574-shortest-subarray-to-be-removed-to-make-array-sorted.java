class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
       int i=0; int j=arr.length-1;
       while(i<arr.length-1){
            if(arr[i]>arr[i+1]){
                break;
            }
            i++;
       } 
       if(i==arr.length-1) return 0;
       while(j>0  && j>i){
            if(arr[j]<arr[j-1]){
                break;
            }
            j--;
       }
        int maxLen=Math.min(arr.length-i-1,j);
        int left=0; int right=j;
       while(left<=i && right<arr.length){
            if(arr[left]<=arr[right]){
                maxLen=Math.min(maxLen,right-left-1);
                left++;
            }
            else{
                right++;
            }
       }
       return maxLen;
    }
}