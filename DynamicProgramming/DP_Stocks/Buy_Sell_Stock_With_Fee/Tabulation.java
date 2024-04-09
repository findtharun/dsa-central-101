package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_With_Fee;

public class Tabulation {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        int[][] dp = new int[n + 1][2];
        for (int day = n - 1; day >= 0; day--) {
            for (int holdingStock = 0; holdingStock <= 1; holdingStock++) {
                if (holdingStock == 1) {
                    int sellToday = prices[day] - fee + dp[day + 1][0];
                    int skipToday = 0 + dp[day + 1][1];
                    dp[day][holdingStock] = Math.max(sellToday, skipToday);
                }
                if (holdingStock == 0) {
                    int buyToday = -prices[day] + dp[day + 1][1];
                    int skipToday = 0 + dp[day + 1][0];
                    dp[day][holdingStock] = Math.max(buyToday, skipToday);
                }
            }
        }
        return dp[0][0];
    }
}
