class Solution {
    public int arrangeCoins(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int i=1; int count=0;
        while(n>0  && i<=n){
            n-=i;
            i++;
            count++;
        }
        return count;
    }
}