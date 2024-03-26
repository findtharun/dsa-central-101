package DynamicProgramming.Knapsack.Knapsack01;

public class Recursion {
    public static int knapsackUtil(int ind, int[] weight, int n, int[] value, int capacity) {
        if (ind == n || capacity == 0) {
            return 0;
        }

        // Calculate the maximum value by either including or excluding the current item
        int notTake = 0 + knapsackUtil(ind + 1, weight, n, value, capacity);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= capacity)
            take = value[ind] + knapsackUtil(ind + 1, weight, n, value, capacity - weight[ind]);
        return Math.max(take, notTake);
    }

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return knapsackUtil(0, weight, n, value, maxWeight);
    }
}
