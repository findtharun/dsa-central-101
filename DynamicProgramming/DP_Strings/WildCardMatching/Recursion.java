package DynamicProgramming.DP_Strings.WildCardMatching;

public class Recursion {
    public boolean wildcardMatchingUtil(int i, int j, String S, String pattern) {
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
        if (i == S.length() || j == pattern.length()) {
            return false;
        }
        if (S.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')
            return wildcardMatchingUtil(i + 1, j + 1, S, pattern);
        else if (pattern.charAt(j) == '*') {
            // Two possibilities when encountering '*':
            // 1. '*' matches one or more characters in S.
            // 2. '*' matches zero characters in S.
            return wildcardMatchingUtil(i + 1, j, S, pattern) ||
                    wildcardMatchingUtil(i, j + 1, S, pattern);
        } else
            return false;
    }

    public boolean isMatch(String s, String p) {
        return wildcardMatchingUtil(0, 0, s, p);
    }
}
