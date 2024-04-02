package DynamicProgramming.DP_Strings.WildCardMatching;

import java.util.Arrays;

public class Memoization {
    public int wildcardMatchingUtil(int i, int j, String S, String pattern, int[][] dp) {
        if (i == S.length() && j == pattern.length())
            return 1;
        // S is Exhausted, check if remaining characters are all '*'.
        // If yes, they can be empty and Match happens
        if (i == S.length()) {
            for (int k = j; k < pattern.length(); k++) {
                if (pattern.charAt(k) != '*')
                    return 0;
            }
            return 1;
        }
        if (i == S.length() || j == pattern.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (S.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')
            return dp[i][j] = wildcardMatchingUtil(i + 1, j + 1, S, pattern, dp);
        else if (pattern.charAt(j) == '*') {
            // Two possibilities when encountering '*':
            // 1. '*' matches one or more characters in S.
            // 2. '*' matches zero characters in S.
            return dp[i][j] = wildcardMatchingUtil(i + 1, j, S, pattern, dp) +
                    wildcardMatchingUtil(i, j + 1, S, pattern, dp);
        } else
            return 0;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return wildcardMatchingUtil(0, 0, s, p, dp) == 0 ? false : true;
    }
}
