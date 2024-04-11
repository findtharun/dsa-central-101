package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;

public class StandardApproach {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        int len = Integer.MIN_VALUE;
        Arrays.fill(dp, 1); // Since If we take only single Element, Length would be 1 at every index
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if (nums[currInd] > nums[prevInd])
                    dp[currInd] = Math.max(dp[currInd], 1 + dp[prevInd]);
            }
            len = Math.max(len, dp[currInd]);
        }
        return len;
    }
}
