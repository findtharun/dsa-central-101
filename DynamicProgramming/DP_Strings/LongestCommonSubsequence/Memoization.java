package DynamicProgramming.DP_Strings.LongestCommonSubsequence;

import java.util.Arrays;

public class Memoization {
    public static int helper(String text1, int t1, String text2, int t2, int[][] dp, String ans) {
        if (t1 == text1.length() || t2 == text2.length())
            return 0;
        if (dp[t1][t2] != -1)
            return dp[t1][t2];
        if (text1.charAt(t1) == text2.charAt(t2)) {
            ans = ans + text1.charAt(t1);
            return dp[t1][t2] = 1 + helper(text1, t1 + 1, text2, t2 + 1, dp, ans);
        } else
            return dp[t1][t2] = Math.max(helper(text1, t1, text2, t2 + 1, dp, ans),
                    helper(text1, t1 + 1, text2, t2, dp, ans));
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        // Write your code here.
        String ans = "";
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int len = helper(s1, 0, s2, 0, dp, ans);
        System.out.println(len); // Length of LCS
        return ans;
    }
}
