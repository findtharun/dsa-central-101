package DynamicProgramming.DP_Subsequences.SubsetsPartitionMinDifference.PositiveConstraints;

import java.util.Arrays;

public class Memoization {
    public static int subsetSumDifferenceUtil(int[] arr, int ind, int p1, int arrSum, int[][] dp) {
        if (ind == arr.length) {
            int p2 = arrSum - p1;
            return Math.abs(p2 - p1);
        }
        if (dp[ind][p1] != -1)
            return dp[ind][p1];
        int notTake = subsetSumDifferenceUtil(arr, ind + 1, p1, arrSum, dp);
        int take = subsetSumDifferenceUtil(arr, ind + 1, p1 + arr[ind], arrSum, dp);
        return dp[ind][p1] = Math.min(take, notTake);
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        int[][] dp = new int[n][arrSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return subsetSumDifferenceUtil(arr, 0, 0, arrSum, dp);
    }
}
