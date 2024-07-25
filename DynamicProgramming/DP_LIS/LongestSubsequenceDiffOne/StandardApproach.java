package DynamicProgramming.DP_LIS.LongestSubsequenceDiffOne;

import java.util.Arrays;

public class StandardApproach {
    public static int longestSubseq(int n, int[] a) {
        if (n == 1)
            return 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is a subsequence of length 1

        int maxLen = 1;

        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if (a[currInd] - a[prevInd] == 1) {
                    dp[currInd] = Math.max(dp[currInd], 1 + dp[prevInd]);
                }
            }
            maxLen = Math.max(maxLen, dp[currInd]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a1 = { 2, 3, 1, 4, 3, 5, 6 };
        System.out.println(longestSubseq(a1.length, a1)); // Output: 5

        int[] a2 = { 1, 2, 3, 4, 5 };
        System.out.println(longestSubseq(a2.length, a2)); // Output: 5

        int[] a3 = { 5, 4, 3, 2, 1 };
        System.out.println(longestSubseq(a3.length, a3)); // Output: 1

        int[] a4 = { 10, 9, 8, 7, 6 };
        System.out.println(longestSubseq(a4.length, a4)); // Output: 1
    }
}
