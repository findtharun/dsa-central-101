package DynamicProgramming.DP_Subsequences.RodCutting;

public class SpaceOptimization {
	public static int cutRod(int price[], int n) {
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        // dp[i][j] represents the maximum obtainable price for a rod of length i and maximum length j.
       for (int maxLen = 1; maxLen <= n; maxLen++) {
            prev[maxLen] = price[0] * (maxLen / (1));
        }
        for(int ind = 1 ;ind < n;ind++){
            for(int maxLen = 0 ;maxLen <=n; maxLen++){
                int notTake = prev[maxLen];
                int take = Integer.MIN_VALUE;
                int rodLen = ind+1;
                if(rodLen <= maxLen)
                    take = price[ind]+ curr[maxLen - rodLen];
                curr[maxLen] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[n];
	}
}
