class Solution {
    int mod=1000000007;
    private long mon(int b, int n){
        if(n==0) return 1;
        long h=mon(b,n/2);
        long res=(h*h)%mod;
        if(n%2 ==1) res= (res*b)%mod;
        return res;
    }
    public int monkeyMove(int n) {
        long res=mon(2,n);
        return (int) ((res-2+mod)%mod);
    }
}