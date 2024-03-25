package DynamicProgramming.DP_Subsequences.SubsetsPartitionMinDifference.PositiveConstraints;

public class Tabulation {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int arrSum = 0;
        for (int i = 0; i < n; i++)
            arrSum += arr[i];

        boolean[][] dp = new boolean[n][arrSum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        if (arr[0] <= arrSum)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= arrSum; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if (arr[ind] <= target)
                    take = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = take || notTake;
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= arrSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (arrSum - i));
                mini = Math.min(diff, mini);
            }
        }
        return mini;
    }
}
