package DynamicProgramming.Knapsack.UnboundedKnapsack;

import java.util.Arrays;

public class Memoization {
    public static int helper(int ind, int n, int capacity, int[] profit, int[] weight, int[][] dp) {
        if (ind == n) {
            return (capacity / weight[ind - 1]) * profit[ind - 1];
        }
        if (dp[ind][capacity] != -1)
            return dp[ind][capacity];
        int notTake = 0 + helper(ind + 1, n, capacity, profit, weight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= capacity)
            take = profit[ind] + helper(ind, n, capacity - weight[ind], profit, weight, dp);
        return dp[ind][capacity] = Math.max(take, notTake);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, n, w, profit, weight, dp);
    }
}
