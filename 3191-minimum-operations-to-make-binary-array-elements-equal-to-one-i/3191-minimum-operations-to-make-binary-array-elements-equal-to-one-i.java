class Solution {
    public int minOperations(int[] arr) {
        int n=arr.length;
        int count=0;
       for(int j=0;j<=n-3;j++){
            if(arr[j]!=0){
                continue;
            }
            else{
                arr[j]=1;
                arr[j+1]=arr[j+1]==0 ? 1 : 0;
                arr[j+2]=arr[j+2]==0 ? 1 : 0;
                count++;
            }
        }
       for(int i : arr){
        if(i==0) return -1;
       }
       return count;
    }
}