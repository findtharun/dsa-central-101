package DynamicProgramming.DP_Strings.EditDistance;

import java.util.Arrays;

public class Memoization {
    public int helper(int i, int j, String word1, String word2, int[][] dp) {
        if (i >= word1.length()) {
        // We have exhausted Chars in Word1, To Convert we need to use remaining chars in word2
            return word2.length() - j;
        }
        if (j >= word2.length()) {
        // We have exhausted Chars in Word2, To Convert we need to use remaining chars in word1
            return word1.length() - i;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) // No Need to Perform any Operation, Go Next Indices in Both
            return dp[i][j] = helper(i + 1, j + 1, word1, word2, dp);
        else {
            int insertion = 1 + helper(i, j + 1, word1, word2, dp); // Made One Insertion to Match Both Characters
            int deletion = 1 + helper(i + 1, j, word1, word2, dp); // Deleted Character to Match Both
            // Move ve to the next characters in both word1 and word2, effectively replacing
            // a character in word1 with a character from word2
            int replace = 1 + helper(i + 1, j + 1, word1, word2, dp);
            return dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        /*
         * The value dp[i][j] represents the minimum edit distance between the
         * substrings word1[:i]
         * and word2[:j], where word1[:i] represents the substring of word1 starting
         * from index i.
         */
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, word1, word2, dp);
    }
}
