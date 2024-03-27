package DynamicProgramming.DP_Subsequences.CountPartitionsWithGivenDifference;

public class SpaceOptimization {
    static int findWays(int[] num, int tar) {
        int mod = (int) 1e9 + 7;
        int n = num.length;

        int prev[] = new int[tar + 1];

        if (num[0] == 0)
            prev[0] = 2; // 2 cases -pick and not pick
        else
            prev[0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            prev[num[0]] = 1; // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = prev[target - num[ind]];

                cur[target] = (notTaken + taken) % mod;
            }
            prev = cur.clone();
        }
        return prev[tar];
    }
}
