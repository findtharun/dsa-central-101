package DynamicProgramming.Knapsack.Knapsack01;

public class SpaceOptimization {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // Initialize two arrays to store maximum value for different capacities
        int[] prev = new int[maxWeight + 1];
        int[] curr = new int[maxWeight + 1];

        // Initialize prev array based on the weight and value of the first item
        for (int wt = 0; wt <= maxWeight; wt++) {
                prev[wt] = value[0];
        }

        // Iterate over the items starting from the second item
        for (int ind = 1; ind < n; ind++) {
            for (int capacity = 0; capacity <= maxWeight; capacity++) {
                int notTake = prev[capacity]; // Maximum value without taking the current item
                int take = Integer.MIN_VALUE; // Initialize take as minimum value

                // If the current item can be taken, calculate the maximum value
                if (weight[ind] <= capacity)
                    take = value[ind] + prev[capacity - weight[ind]]; // Maximum value by taking the current item

                // Update the current capacity with the maximum value
                curr[capacity] = Math.max(take, notTake);
            }

            // Update prev array for the next iteration
            prev = curr.clone();
        }

        // Return the maximum value that can be obtained with the given maxWeight
        return prev[maxWeight];
    }
}
