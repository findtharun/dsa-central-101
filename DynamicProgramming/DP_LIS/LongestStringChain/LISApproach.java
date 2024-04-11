package DynamicProgramming.DP_LIS.LongestStringChain;

import java.util.*;

public class LISApproach {
    public boolean checkPossible(String curr, String prev) {
        if (curr.length() != 1 + prev.length())
            return false;
        int i = 0;
        int j = 0;
        while (i < curr.length()) {
            if (j < prev.length() && curr.charAt(i) == prev.charAt(j)) {
                i++;
                j++;
            } else
                i++;
        }
        return i == curr.length() && j == prev.length();
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        if (n == 1)
            return 1;
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // Sort in Ascending order of word lengths
            }
        };
        Arrays.sort(words, comp);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int len = 0;
        for (int currInd = 1; currInd < n; currInd++) {
            for (int prevInd = 0; prevInd < currInd; prevInd++) {
                if (checkPossible(words[currInd], words[prevInd]) && (1 + dp[prevInd] > dp[currInd])) {
                    dp[currInd] = 1 + dp[prevInd];
                }
            }
            len = Math.max(dp[currInd], len);
        }
        return len;
    }
}
