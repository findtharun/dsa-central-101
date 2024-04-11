package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;

// Solution for Printing LIS is based on Standard Approach
public class PrintLIS {
    public static List<Integer> printingLongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Since If we take only single Element, Length would be 1 at every index

        int[] source = new int[n];// Stores the index of the previous element in the longest increasing
                                  // subsequence ending at index i
        Arrays.fill(source, -1);
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if ((nums[currInd] > nums[prevInd]) && (1 + dp[prevInd] > dp[currInd])) {
                    dp[currInd] = Math.max(dp[currInd], 1 + dp[prevInd]);
                    source[currInd] = prevInd;
                }
            }
        }

        int len = -1;
        int lastInd = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > len) {
                len = dp[i];
                lastInd = i;
            }
        }

        List<Integer> subSeq = new ArrayList<>();
        subSeq.add(source[lastInd]);
        while (source[lastInd] != -1) {
            lastInd = source[lastInd];
            subSeq.add(nums[lastInd]);
        }
        Collections.reverse(subSeq);
        return subSeq;
    }
}
