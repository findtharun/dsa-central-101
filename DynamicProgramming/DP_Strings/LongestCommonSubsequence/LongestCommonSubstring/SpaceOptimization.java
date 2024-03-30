package DynamicProgramming.DP_Strings.LongestCommonSubsequence.LongestCommonSubstring;

public class SpaceOptimization {
    public static int lcs(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[] prev= new int[n2 + 1];
        int[] curr= new int[n2 + 1]; 
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(curr[j], ans);
                } else
                    curr[j] = 0;
            }
            prev = curr.clone();
        }
        return ans;
    }
}
