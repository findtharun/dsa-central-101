package DynamicProgramming.Knapsack.Knapsack01;

public class Tabulation {
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for (int wt = weight[0]; wt <= maxWeight; wt++) {
            dp[0][wt] = value[0]; // If First Item is Less than Max Weight, we can add in knapsack
        }

        for (int ind = 1; ind < n; ind++) {
            for (int capacity = 0; capacity <= maxWeight; capacity++) {
                int notTake = dp[ind - 1][capacity];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= capacity)
                    take = value[ind] + dp[ind - 1][capacity - weight[ind]];
                dp[ind][capacity] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][maxWeight];
    }
}
