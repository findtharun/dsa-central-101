package DynamicProgramming.DP1D.MaxSumNonAdjacentSubsequence;

import java.util.ArrayList;

public class SpaceOptimization {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;

        // Iterate through the numsay starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum by either picking the current element or not
            // picking it.
            int pick = nums.get(i);

            // If there are at least two elements before the current element, add the value
            // from prev2.
            if (i > 1)
                pick += prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int nonPick = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }

        // The 'prev' variable now holds the maximum possible sum.
        return prev;
    }
}
