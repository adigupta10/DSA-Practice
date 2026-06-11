class Solution {
    public int trailingZeroes(int n) {
        if(n<5) return 0;
        int sum=0;
        while(n>0){
            n/=5;
            sum+=n;
        }
        return sum;
    }
}