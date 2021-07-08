package LeetcodeProblems;

public class BuyAndSellStocks {
    //Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int max_profit = 0, buyAt = prices[0];
        for(int i = 1; i<prices.length; i++){
            buyAt = Math.min(buyAt, prices[i]);
            if(prices[i]>buyAt){
                max_profit = Math.max(max_profit, prices[i] - buyAt);

            }
        }
        return max_profit;
    }
}
