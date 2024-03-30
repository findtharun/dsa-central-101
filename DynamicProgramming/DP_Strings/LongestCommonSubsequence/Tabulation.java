package DynamicProgramming.DP_Strings.LongestCommonSubsequence;

import java.util.Arrays;

public class Tabulation {
    public static String findLCS(int n, int m, String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        // Initialize the first row and first column with zeros since LCS with an empty
        // string is zero
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = 0;
        }

        // dp[i][j] represents Length of LCS with String s1[:i], String s2[:j]
        for (int ind1 = 1; ind1 <= n1; ind1++) {
            for (int ind2 = 1; ind2 <= n2; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        int len = dp[n1][n2]; // Length of Longest Common Subsequence
        char[] lcs = new char[len];
        int index = len - 1;
        int i = n1;
        int j = n2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index] = s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // It Implies we got the Longest one at dp[i-1][j] - hence decrease i
                i--;
            } else {
                j--;
            }
        }
        return new String(lcs);
    }
}
