package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_Cooling_Period;

public class Tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        // Create a 2D array to store the maximum profit at each day and holding status
        // 0 -> not holding, 1 -> holding
        int[][] dp = new int[n + 2][2];
        int profit = 0;

        // Calculate the maximum profit for each day
        for (int day = n - 1; day >= 0; day--) {
            for (int holdingStock = 0; holdingStock <= 1; holdingStock++) {
                if (holdingStock == 0) {
                    profit = Math.max(-prices[day] + dp[day + 1][1], 0 + dp[day + 1][0]);
                }
                if (holdingStock == 1) {
                    profit = Math.max(prices[day] + dp[day + 2][0], 0 + dp[day + 1][1]);
                }
                dp[day][holdingStock] = profit;
            }
        }
        return dp[0][0];
    }
}
