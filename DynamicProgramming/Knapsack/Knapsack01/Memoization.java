package DynamicProgramming.Knapsack.Knapsack01;

import java.util.Arrays;

public class Memoization {
    public static int knapsackUtil(int ind, int[] weight, int n, int[] value, int capacity, int[][] dp) {
        if (ind == n || capacity == 0) {
            return 0;
        }

        if (dp[ind][capacity] != -1)
            return dp[ind][capacity];

        // Calculate the maximum value by either including or excluding the current item
        int notTake = 0 + knapsackUtil(ind + 1, weight, n, value, capacity, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= capacity)
            take = value[ind] + knapsackUtil(ind + 1, weight, n, value, capacity - weight[ind], dp);
        return dp[ind][capacity] = Math.max(take, notTake);
    }

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return knapsackUtil(0, weight, n, value, maxWeight, dp);
    }
}
