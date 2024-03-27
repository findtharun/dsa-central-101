package DynamicProgramming.DP_Subsequences.TargetSum;

import java.util.Arrays;

public class Memoization {
    int helper(int[] nums, int ind, int sum, int S, int[][] dp, int total) {
        if (ind == nums.length) {
            if (S == sum)
                return 1;
            return 0;
        }
        // Since we can not have negative Indices, we will add Total Sum to Indices so
        // that Negative Indices gets Positive

        if (dp[ind][sum + total] != Integer.MIN_VALUE)
            return dp[ind][sum + total];
        // Positive
        int pos = helper(nums, ind + 1, sum + nums[ind], S, dp, total);
        // Negative
        int neg = helper(nums, ind + 1, sum - nums[ind], S, dp, total);
        return dp[ind][sum + total] = pos + neg;
    }

    public int findTargetSumWays(int[] nums, int S) {
        int total = 0;
        for (int ele : nums)
            total += ele;
        // Size is 2*S +1 Because to Accomodate Negative Sum, Positive Sum and Zero
        int[][] dp = new int[nums.length][2 * total + 1];
        // Constraints are between 1000 only, So We can fill DP with Int Min Value
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        return helper(nums, 0, 0, S, dp, total);
    }
}
