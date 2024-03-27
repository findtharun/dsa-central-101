package DynamicProgramming.Knapsack.UnboundedKnapsack;

public class SpaceOptimization {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];
        int[] curr = new int[w + 1];
        for (int wt = weight[0]; wt <= w; wt++) {
            prev[wt] = ((int) wt / weight[0]) * profit[0]; // Since we can take Multiple Times
        }
        for (int ind = 1; ind < n; ind++) {
            for (int capacity = 0; capacity <= w; capacity++) {
                int notTake = prev[capacity];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= capacity) {
                    take = profit[ind] + curr[capacity - weight[ind]]; // Since we can take Multiple Times
                }
                curr[capacity] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[w];
    }
}
