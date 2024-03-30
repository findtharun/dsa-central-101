package DynamicProgramming.DP_Strings.DistinctSubsequences;

public class Tabulation {
    static int mod = (int) (Math.pow(10, 9) + 7);
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        // dp[i][j] represents distinct subsequences for s[:i] and t[:j]
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++)
            dp[i][0] = 1; // cause there's one empty subsequence in any string.
        // Initialize the first row (except dp[0][0] because it is filled above) with 0 because there's no way to form s2 from an empty string
        for (int i = 1; i < n2 + 1; i++)
            dp[0][i] = 0; 
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    int leaveOne = dp[i - 1][j - 1];
                    int stay = dp[i - 1][j];
                    dp[i][j] = (leaveOne + stay) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}
