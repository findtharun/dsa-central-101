package DynamicProgramming.DP1D.MaxSumNonAdjacentSubsequence;

import java.util.ArrayList;

public class Tabulation {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        dp[0] = nums.get(0);
        if (n >= 2)
            dp[1] = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < n; i++) {
            int pick = nums.get(i) + dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }
}
