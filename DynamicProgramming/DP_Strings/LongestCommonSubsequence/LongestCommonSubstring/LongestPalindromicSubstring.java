package DynamicProgramming.DP_Strings.LongestCommonSubsequence.LongestCommonSubstring;

public class LongestPalindromicSubstring {
    public String longestCommonSubstring(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[i][j] represents Length of LCS with String s1[:i], String s2[:j]
        int maxLen = 0;
        int endIndex = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1; // Update the ending index of the substring
                    }
                } else {
                    dp[i][j] = 0; // Reset the length of common substring if characters don't match
                }
            }
        }
        // Construct the longest common substring
        if (maxLen == 0) {
            return ""; // If there is no common substring
        }
        return s1.substring(endIndex - maxLen + 1, endIndex + 1); // Return the substring
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return longestCommonSubstring(s, rev);
    }
}
