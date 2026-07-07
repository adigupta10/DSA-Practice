class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        long sum=0;
        StringBuilder s=new StringBuilder();
        while(n!=0){
            int rem=n%10;
            if(rem>0){
                s.append(String.valueOf(rem));
                sum+=rem;
            }
            n/=10;
        }
        s=s.reverse();
        long ans=Long.parseLong(s.toString()) * sum;
        return ans;
    }
}