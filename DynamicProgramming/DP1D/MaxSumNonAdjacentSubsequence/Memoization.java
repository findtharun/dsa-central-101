package DynamicProgramming.DP1D.MaxSumNonAdjacentSubsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {
    public static int solve(int idx, ArrayList<Integer> nums, int[] dp) {
        if (idx == 0)
            return nums.get(idx);
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int pick = nums.get(idx) + solve(idx - 2, nums, dp);
        int notPick = 0 + solve(idx - 1, nums, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int res = solve(n - 1, nums, dp);
        return res;
    }
}
