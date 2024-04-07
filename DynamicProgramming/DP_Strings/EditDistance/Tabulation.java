package DynamicProgramming.DP_Strings.EditDistance;

public class Tabulation {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        /*
         * The value dp[i][j] represents the minimum edit distance between the
         * substrings word1[:i] and word2[:j]
         */
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i; // If Only 1 Character in word2, to Match We need to Make I Operations
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j; // If Only 1 Character in word1 , to Match We need to Make J Operations
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insertions = dp[i][j - 1]; // Insert the character from S2 into S1 (up).
                    int deletions = dp[i - 1][j]; // Delete the character in S1 (left).
                    int replace = dp[i - 1][j - 1]; // Replace the character in S1 with the character in S2 (diagonal).
                    dp[i][j] = 1 + Math.min(insertions, Math.min(deletions, replace));
                }
            }
        }

        return dp[n1][n2];
    }
}
