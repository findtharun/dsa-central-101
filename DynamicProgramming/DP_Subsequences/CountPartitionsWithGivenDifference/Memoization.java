package DynamicProgramming.DP_Subsequences.CountPartitionsWithGivenDifference;

import java.util.Arrays;

public class Memoization {
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static int countSubsetsWithSumK(int ind, int[] arr, int k, int[][] dp) {
        /* if (ind == arr.length - 1) { // Ideally condition should be ind == arr.length , but some how for this it is different. Check Subset with Sum K Solution
            if (k == 0 && arr[arr.length - 1] == 0)
                return 2;
            if (k == 0 || k == arr[arr.length - 1])
                return 1;
            return 0;
        } */
        if(ind == arr.length){
            if(k == 0) return 1;
            return 0;
        }
        if (dp[ind][k] != -1)
            return dp[ind][k];
        int notTake = countSubsetsWithSumK(ind + 1, arr, k, dp);
        int take = 0;
        if (arr[ind] <= k)
            take = countSubsetsWithSumK(ind + 1, arr, k - arr[ind], dp);
        return dp[ind][k] = (take + notTake) % mod;
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int arrSum = 0;
        for (int i = 0; i < n; i++)
            arrSum += arr[i];
        /*
         * We need 2 Subsets with Difference sum as D
         * S1-S2 = D;
         * (arrSum-s2)-S2 = D;
         * arrSum-D = 2 * S2;
         * S2 = (arrSum-D)/2;
         * Thus we need to find the number of subsets having sum as S2
         */

        // If Target Sum is Odd we can not perform Partition
        if (arrSum - d < 0)
            return 0;
        if ((arrSum - d) % 2 != 0)
            return 0;
        int targetSum = (arrSum - d) / 2;
        int[][] dp = new int[n][targetSum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int res = countSubsetsWithSumK(0, arr, targetSum, dp);
        return res;
    }
}
