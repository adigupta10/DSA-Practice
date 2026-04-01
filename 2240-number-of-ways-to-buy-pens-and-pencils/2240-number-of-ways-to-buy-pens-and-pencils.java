class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
       long n=total/cost1;
       long sum=0;
       for(long i=0;i<=n;i++){
         long temp=total-(i*cost1);
         sum+=(long) temp/cost2;
         sum+=1;
       }
       return sum; 
    }
}