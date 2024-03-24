package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK;

import java.util.Arrays;

public class Memoization {
    public static int hasSubsetSum(int[] arr, int ind, int k, int[][] dp) {
        // Base Cases
        if (k == 0)
            return 1;
        if (ind == arr.length) // We have Explored all Ways on that path but no subset has been found , If it has found it would have been returned at before line
            return 0;

        // Check if result already exists in dp
        if (dp[ind][k] != -1)
            return dp[ind][k];

        // If current element is greater than sum, then ignore it
        if (arr[ind] > k) {
            dp[ind][k] = hasSubsetSum(arr, ind + 1, k, dp);
            return dp[ind][k];
        }

        // Check if sum can be obtained by including the current element or excluding it
        int result = hasSubsetSum(arr, ind + 1, k, dp) + hasSubsetSum(arr, ind + 1, k - arr[ind], dp);

        // Store the result in dp
        return dp[ind][k] = result;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        int[][] dp = new int[arr.length][k + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return hasSubsetSum(arr, 0, k, dp) == 0 ? false : true;
    }
}
