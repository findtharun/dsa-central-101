package DynamicProgramming.Knapsack.UnboundedKnapsack;

public class Recursion {
    public static int helper(int ind, int n, int capacity, int[] profit, int[] weight) {
        if (ind == n) {
            return (capacity / weight[ind - 1]) * profit[ind - 1]; // Since We can Take Multiple Times
        }
        int notTake = 0 + helper(ind + 1, n, capacity, profit, weight);
        int take = 0;
        if (weight[ind] <= capacity)
            take = profit[ind] + helper(ind, n, capacity - weight[ind], profit, weight);
        return Math.max(take, notTake);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return helper(0, n, w, profit, weight);
    }
}
