package DynamicProgramming.DP_Strings.WildCardMatching;

public class Memoization {
    public boolean wildcardMatchingUtil(int i, int j, String S, String pattern, Boolean[][] dp) {
        if (i == S.length() && j == pattern.length())
            return true;
        // S is Exhausted, check if remaining characters in Pattern are all '*'.
        // If yes, they can be empty and Match happens
        if (i == S.length()) {
            for (int k = j; k < pattern.length(); k++) {
                if (pattern.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (j == pattern.length() && i < S.length()) {
            return false;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (S.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')
            return dp[i][j] = wildcardMatchingUtil(i + 1, j + 1, S, pattern, dp);
        else if (pattern.charAt(j) == '*') {
            // Two possibilities when encountering '*':
            // 1. '*' matches one or more characters in S.
            // 2. '*' matches zero characters in S.
            return dp[i][j] = wildcardMatchingUtil(i + 1, j, S, pattern, dp) ||
                    wildcardMatchingUtil(i, j + 1, S, pattern, dp);
        } else
            return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return wildcardMatchingUtil(0, 0, s, p, dp);
    }
}
