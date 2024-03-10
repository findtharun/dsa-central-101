package DynamicProgramming.Fundamentals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopDownFibonacci {

    static int f(int n, int[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(n, dp));

    }

    // In Memoization HashMap/Array is used depending on whether we deal with Indices
    public int fib(int n) {
        Map<Integer, Integer> fibCache = new HashMap<>();
        if (fibCache.containsKey(n))
            return fibCache.get(n);
        if (n <= 1)
            return n;
        int fibVal = fib(n - 1) + fib(n - 2);
        fibCache.put(n, fibVal);
        return fibVal;
    }
}
