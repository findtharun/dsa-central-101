package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_I;

public class SpaceOptimization {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int min_so_far = prices[0];
        int max_profit = 0;
        for (int i = 1; i < n; i++) {
            int curr_profit = prices[i] - min_so_far;
            max_profit = Math.max(curr_profit, max_profit);
            min_so_far = Math.min(min_so_far, prices[i]);
        }
        return max_profit;
    }
}
