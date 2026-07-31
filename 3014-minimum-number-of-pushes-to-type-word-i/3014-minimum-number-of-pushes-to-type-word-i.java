class Solution {
    public int minimumPushes(String word) {
        int sum=0;
        int press=1;
        int idx=1;
        int i=0;
        int n=word.length();
        while(i+8<n){
            sum+=8*idx;
            i=i+8;
            idx++;
        }
        if(i<n){
            sum+=(n-1-i+1)*idx;
        }
        return sum;
    }
}