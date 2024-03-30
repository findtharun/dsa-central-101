package DynamicProgramming.DP_Strings.DistinctSubsequences;

import java.util.Arrays;

public class Memoization {
    static int mod = (int) (Math.pow(10, 9) + 7);
    // dp[i][j] represents distinct subsequences for s[:i] and t[:j]
    public int helper(int ind1, String s, int ind2, String t,int[][] dp) {
        if (ind2 >= t.length())
            return 1;
        if (ind1 >= s.length())
            return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        // If the characters at the current positions match, we can either leave one character from s1
        // or continue to the next character in s1 while staying at the same character in s2.
        if (s.charAt(ind1) == t.charAt(ind2)) {
            int leaveOne = helper(ind1 + 1, s, ind2 + 1, t, dp);
            int stay = helper(ind1 + 1, s, ind2, t, dp);
            return dp[ind1][ind2] = (leaveOne + stay) % mod;
        }else //If the characters don't match, we can only continue to the next character in s1.
            return dp[ind1][ind2] = helper(ind1 + 1, s, ind2, t, dp);
    }
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1][n2];
         for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return helper(0, s, 0, t, dp);
    }
}
