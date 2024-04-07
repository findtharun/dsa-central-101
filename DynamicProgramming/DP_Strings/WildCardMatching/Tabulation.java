package DynamicProgramming.DP_Strings.WildCardMatching;

public class Tabulation {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // Create a 2D array to store the matching results
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: both empty strings match
        dp[0][0] = true;

        // Initialize the first column based on wildcard '*' in pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill in the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Two possibilities when encountering '*':
                    // 1. '*' matches one or more characters in s.
                    // 2. '*' matches zero characters in s.
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        // Return the result for the whole strings
        return dp[n][m];
    }

}
