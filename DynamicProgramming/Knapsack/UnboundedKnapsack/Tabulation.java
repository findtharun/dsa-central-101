package DynamicProgramming.Knapsack.UnboundedKnapsack;

public class Tabulation {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int wt = weight[0]; wt <= w; wt++) {
            dp[0][wt] = ((int) wt / weight[0]) * profit[0]; // Since we can take Multiple Times
        }
        for (int ind = 1; ind < n; ind++) {
            for (int capacity = 0; capacity <= w; capacity++) {
                int notTake = dp[ind - 1][capacity];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= capacity) {
                    take = profit[ind] + dp[ind][capacity - weight[ind]]; // Since we can take Multiple Times
                }
                dp[ind][capacity] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][w];
    }
}
