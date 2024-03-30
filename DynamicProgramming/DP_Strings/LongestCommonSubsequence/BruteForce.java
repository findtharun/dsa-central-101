package DynamicProgramming.DP_Strings.LongestCommonSubsequence;

public class BruteForce {
    public static String findLCS(int n, int m, String s1, String s2) {
        String longest = "";
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    longest += s1.charAt(i);
                }
            }
        return longest;
    }
}
