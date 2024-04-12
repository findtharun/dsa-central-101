package DynamicProgramming.DP_LIS;

import java.util.*;
// https://www.naukri.com/code360/problems/longest-bitonic-sequence_1062688
public class LongestBiotonicSubsequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dpLis = new int[n]; // For Longest Increasing Subsequence
        int[] dpLds = new int[n]; // For Longest Decreasing Subsequence
        Arrays.fill(dpLis, 1);
        Arrays.fill(dpLds, 1);
        // Longest Increasing Subsequence
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if ((arr[currInd] > arr[prevInd]) && (1 + dpLis[prevInd] > dpLis[currInd]))
                    dpLis[currInd] = Math.max(dpLis[currInd], 1 + dpLis[prevInd]);
            }
        }
        // Longest Decreasing Subsequence
        for (int currInd = n - 2; currInd >= 0; currInd--) {
            for (int nextInd = n - 1; nextInd > currInd; nextInd--) {
                if (arr[currInd] > arr[nextInd] && dpLds[currInd] < 1 + dpLds[nextInd])
                    dpLds[currInd] = 1 + dpLds[nextInd];
            }
        }

        int maxi = -1;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dpLis[i] + dpLds[i] - 1);
        }
        return maxi;
    }
}
