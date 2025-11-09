class Solution {
    public int countPrimes(int n) {
        boolean[] arr=new boolean[n];
        if(n<3) return 0;
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i*i<n;i++){
            if(arr[i]){
                for(int j=i*i;j<n;j+=i){
                    arr[j]=false;
                }
            }
        }
        int count=0;
        for(boolean i: arr){
            if(i) count++;
        }
        return count;
    }
}