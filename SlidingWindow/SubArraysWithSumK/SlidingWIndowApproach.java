package SlidingWindow.SubArraysWithSumK;

import java.util.ArrayList;
import java.util.List;
/*
    Time Complexity: O( N )
    Space Complexity: O( N )

    where N is the size of array 'A'.
*/
public class SlidingWIndowApproach {
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        // This will keep all those sub-arrays whose sum = 'k'.

        // start and end are the starting
        // and the ending indices of our current
        // subarray
        int start = 0, end = -1;
        long currentSum = 0l;

        // Iterating over 'a'
        while (start < n) {

            // Increasing the right end
            // till our sum <= 'k' or we
            // are not out of bounds
            while ((end + 1 < n) && (currentSum + a[end + 1] <= k)) {
                currentSum += a[end + 1];
                ++end;
            }

            // We have found a subarray with the
            // required sum.
            if (currentSum == k) {
                List<Integer> temp = new ArrayList<>();

                for (int i = start; i <= end; ++i) {
                    temp.add(a[i]);
                }
                ans.add(new ArrayList<>(temp));
            }

            // Shifting the start index
            currentSum -= a[start];
            ++start;
        }

        return ans;
    }
}
