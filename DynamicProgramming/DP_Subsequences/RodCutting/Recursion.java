package DynamicProgramming.DP_Subsequences.RodCutting;

public class Recursion {
    public static int cutRodUtil(int ind, int[] price, int maxLen) {
        if (ind >= maxLen || maxLen == 0) {
            return 0;
        }
        int notTake = cutRodUtil(ind + 1, price, maxLen);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= maxLen)
            take = price[ind] + cutRodUtil(ind, price, maxLen - rodLength);
        return Math.max(take, notTake);
    }

    public static int cutRod(int price[], int n) {
        return cutRodUtil(0, price, n);
    }
}
