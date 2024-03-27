package DynamicProgramming.DP_Subsequences.TargetSum;

import java.util.Arrays;

public class Tabulation {
    public int findTargetSumWays(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        // dp[i][j] refers to the number of assignments which can lead to a sum of j up
        // to the ithindex.
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        return Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
    }
}
