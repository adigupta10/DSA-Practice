class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int ans=prices[0]+prices[1];  //as we have to buy only two chocolates
        if(ans<=money) return money-ans;
        return money;
    }
}