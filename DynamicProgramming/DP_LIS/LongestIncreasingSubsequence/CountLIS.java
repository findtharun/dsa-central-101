package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class CountLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int[] dp = new int[n]; // Length of LIS Till Ith Index
        int[] count = new int[n]; // Count of LIS till Ith Index
        Arrays.fill(count, 1);
        int len = -1;
        Arrays.fill(dp, 1); // Since If we take only single Element, Length would be 1 at every index
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if ((nums[currInd] > nums[prevInd]) && (1 + dp[prevInd] > dp[currInd])) {
                    dp[currInd] = Math.max(dp[currInd], 1 + dp[prevInd]);
                    count[currInd] = count[prevInd];
                } else if ((nums[currInd] > nums[prevInd]) && (1 + dp[prevInd] == dp[currInd])) {
                    count[currInd] = count[currInd] + count[prevInd];
                }
            }
            len = Math.max(len, dp[currInd]);
        }
        // We got the Maximum length of LIS , Count the number of occurences and return
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == len) {
                res = res + count[i];
            }
        }
        return res;
    }
}
