class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        int a=numBottles;
        while(a!=0){
            a=a/numExchange;
            if(a==0) break;
            int left=a%numExchange;
            sum+=a;
            a+=left;
        }
        return sum;
    }
}