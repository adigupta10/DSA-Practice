class Solution {
    public boolean ans(int n){
        if(n==1) return true;
        if(n<=0) return false;
        if(n%2==0) return ans(n/2);
        else return false;
    }
    public boolean isPowerOfTwo(int n) {
        return ans(n);
    }
}