class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==dividend) return 1;
        boolean sign=true;
        if(dividend >=0 && divisor <0) sign =false;
        else if(dividend <=0 && divisor >0) sign =false;
        long n=Math.abs(dividend);
        long d=Math.abs(divisor);
        divisor = Math.abs(divisor);
        int quotient =0;
        while(n>=d){
            int c=0;
            while(n>=(d<<(c+1))){
                c+=1;
            }
            quotient+=1<<c;
            n-=(d<<c);
        }
        if(quotient ==(1<<31) && sign){
            return Integer.MAX_VALUE;
        }
        if(quotient ==(1<<31) && !sign){
            return Integer.MIN_VALUE;
        }
        return sign? quotient : -quotient;
    }
}