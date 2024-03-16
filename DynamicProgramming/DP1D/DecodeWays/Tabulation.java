package DynamicProgramming.DP1D.DecodeWays;

public class Tabulation {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9')
                dp[i] = dp[i] + dp[i - 1];
            int lenTwoStr = Integer.parseInt(s.substring(i - 2, i));
            if (lenTwoStr >= 10 && lenTwoStr <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
