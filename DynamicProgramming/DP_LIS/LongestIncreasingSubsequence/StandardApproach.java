package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;

public class StandardApproach {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Since If we take only single Element, Length would be 1 at every index
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if ((nums[currInd] > nums[prevInd]) && (1 + dp[prevInd] > dp[currInd]))
                    dp[currInd] = Math.max(dp[currInd], 1 + dp[prevInd]);
            }
        }

        int len = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > len) {
                len = dp[i];
            }
        }
        return len;
    }
}
