class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        int n=arr.length;
        for(int x:arr) sum+=x;
        int fr=0;
        for(int i=0;i<n-2;i++){
            int temp=sum;
            fr+=arr[i];
            int sc=0;
            for(int j=i+1;j<n-1;j++){
                sc+=arr[j];
                if(fr==sc){
                    temp-=(fr+sc);
                    if(temp==fr) return true;
                }
            }
        }
        return false;
    }
}