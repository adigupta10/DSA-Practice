class Solution {
    public int numRescueBoats(int[] arr, int l) {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int count=0;
        while(i<=j){
           if(arr[i]+arr[j]<=l){
            i++;
            j--;
            count++;
           } 
           else{
            j--;
            count++;
           }
        }
        return count;
    }
}