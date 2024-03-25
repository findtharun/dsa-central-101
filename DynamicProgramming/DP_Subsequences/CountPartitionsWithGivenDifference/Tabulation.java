package DynamicProgramming.DP_Subsequences.CountPartitionsWithGivenDifference;

public class Tabulation {
    public static int countPartitions(int n, int d, int[] arr) {
        int mod = (int) 1e9 + 7;
        int arrSum = 0;
        for (int i = 0; i < n; i++)
            arrSum += arr[i];
        if (arrSum - d < 0)
            return 0;
        if ((arrSum - d) % 2 != 0)
            return 0;
        int targetSum = (arrSum - d) / 2;
        int[][] dp = new int[n][targetSum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        if (arr[0] == 0)
            dp[0][0] = 2;
        if (arr[0] <= targetSum && arr[0] != 0)
            dp[0][arr[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= targetSum; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (arr[ind] <= target)
                    take = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = (take + notTake) % mod;
            }
        }
        return dp[n - 1][targetSum];
    }
}
