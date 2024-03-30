package DynamicProgramming.DP_Strings.LongestCommonSubsequence.LongestCommonSubstring;

public class Tabulation {
    public static int lcs(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[i][j] represents Length of LCS with String s1[:i], String s2[:j]
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = 0;
        }
        int ans = Integer.MIN_VALUE;
        // dp[i][j] represents Length of LCS with String s1[:i], String s2[:j]
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(dp[i][j], ans);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
}
