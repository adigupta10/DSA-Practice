class Solution {
    public int[] rearrangeArray(int[] arr) {
        int[] neg=new int[arr.length/2];
        int[] pos=new int[arr.length/2];
        int nidx=0;
        int pidx=0;
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            if(curr<0){
                neg[nidx++]=curr;
            }
            else{
                pos[pidx++]=curr;
            }
        }
        int[] res=new int[arr.length];
        pidx=0;
        nidx=0;
        for(int i=0;i<arr.length;i+=2){
            res[i]=pos[pidx];
            pidx++;
            res[i+1]=neg[nidx];
            nidx++;

        }
        return res;
    }
}