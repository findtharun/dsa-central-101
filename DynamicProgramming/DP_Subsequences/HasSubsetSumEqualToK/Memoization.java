package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK;

import java.util.Arrays;

public class Memoization {
    public static boolean hasSubsetSum(int[] arr, int ind, int k, int[][] dp) {
        // Base Cases
        if (ind == arr.length) {
            if (k == 0)
                return true;
            return false;
        }

        // Check if result already exists in dp
        if (dp[ind][k] != -1)
            return dp[ind][k] == 0 ? false : true;

        boolean notTaken = hasSubsetSum(arr, ind + 1, k, dp);
        boolean taken = false;
        if (arr[ind] <= k)
            taken = hasSubsetSum(arr, ind + 1, k - arr[ind], dp);
        // Store the result in dp
        dp[ind][k] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        int[][] dp = new int[arr.length][k + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return hasSubsetSum(arr, 0, k, dp);
    }
}
