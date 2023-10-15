//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class BruteForce {
    public static boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int n = bloomDay.length;
        int cnt = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
                if (cnt == k) {
                    noOfB++;
                    cnt = cnt - k;
                }
            } else { // Means Continuous Sequence Broken Hence Calculating the Boquets
                cnt = 0;
            }
        }

        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long) m * k;
        if (val > n)
            return -1; // Impossible case.
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        for (int day = mini; day <= maxi; day++) {
            if (isPossible(bloomDay, day, m, k)) {
                return day;
            }
        }
        return -1;
    }
}
