class Solution {
    public int maxProfit(int[] prices) {
        int i=0; int j=1;
        int maxi=0;
        while(j<prices.length){
            if(prices[i]>prices[j]){
                i=j;
            }
            else{
                maxi=Math.max(maxi,prices[j]-prices[i]);
            }
            j++;
        }
        return maxi;
    }
}