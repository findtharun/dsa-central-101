package DynamicProgramming.DP_Strings;

import java.util.Arrays;

public class MinDeletionsToMakeEqual {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
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
        for (int ind1 = 1; ind1 <= n1; ind1++) {
            for (int ind2 = 1; ind2 <= n2; ind2++) {
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int minDistance(String word1, String word2) {
        // Maximum Operations can be len(word1) + len(word2)
        /*
         * Minimum Operations
         * We need to Make Sure that we do not disturb the common ones (i.e common
         * subsequence)
         * Insertions = len(word1) - len(lcs)
         * Deletions = len(word2) - len(lcs)
         * Ex : abcd , anc - answer is 3
         */
        int n1 = word1.length();
        int n2 = word2.length();
        int lcs = longestCommonSubsequence(word1, word2);
        int insertions = n1 - lcs;
        int deletions = n2 - lcs;
        return insertions + deletions;
    }
}
