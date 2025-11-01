class Solution {
    public int hIndex(int[] citations) {
        int[] arr=new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=arr.length-1){
                arr[arr.length-1]++;
            }
            else{
                arr[citations[i]]++;
            }
        }
        int sum=0;
        for(int j=arr.length-1;j>=0;j--){
            sum+=arr[j];
            if(sum>=j){
                return j;
            }
        }
        return 0;
    }
}