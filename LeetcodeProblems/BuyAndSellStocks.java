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

    //Buy Sell 2 - Infinite Transactions
    public int maxProfit2(int[] prices) {
        //infinite transactions
        int buyPrice = prices[0], sellPrice = prices[0], profit = 0;
        for(int i = 1; i<prices.length-1; i++){
            if(prices[i]>sellPrice){
                sellPrice = prices[i];
            }
            else{
                profit += sellPrice-buyPrice;
                buyPrice = prices[i];
                sellPrice = prices[i];
            }
        }
        //handling the last term at the end.
        if(prices[prices.length-1]>sellPrice) sellPrice = prices[prices.length-1];

        return profit+sellPrice-buyPrice;
    }
}
