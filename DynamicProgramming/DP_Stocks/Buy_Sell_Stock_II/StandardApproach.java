package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_II;

public class StandardApproach {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
