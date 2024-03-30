package DynamicProgramming.DP_Strings.LongestCommonSubsequence;

public class Recursion {
    public static int helper(String text1, int t1, String text2, int t2, String ans) {
        if (t1 == text1.length() || t2 == text2.length())
            return 0;
        if (text1.charAt(t1) == text2.charAt(t2)) {
            ans = ans + text1.charAt(t1);
            return 1 + helper(text1, t1 + 1, text2, t2 + 1, ans);
        } else
            // Subsequence can be obtained by skipping one or more characters
            return Math.max(helper(text1, t1, text2, t2 + 1, ans), helper(text1, t1 + 1, text2, t2, ans));
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        String ans = "";
        int len = helper(s1, 0, s2, 0, ans);
        System.out.println(len); // Length of LCS
        return ans;
    }
}
