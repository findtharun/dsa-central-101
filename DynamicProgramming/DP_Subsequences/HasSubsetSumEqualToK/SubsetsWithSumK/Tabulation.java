package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK.SubsetsWithSumK;

public class Tabulation {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        for (int ind = 0; ind < n; ind++)
            dp[ind][0] = 1;

        if (num[0] <= tar)
            dp[0][num[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= tar; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (num[ind] <= target) {
                    take = dp[ind - 1][target - num[ind]];
                }
                dp[ind][target] = (take + notTake) % ((int) (1e9) + 7);
            }
        }
        return dp[n - 1][tar];
    }
}
