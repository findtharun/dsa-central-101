package SlidingWindow.SubArraysWithSumK;

import java.util.*;

public class Bruteforce {
    /*
     * Time Complexity: O( N^2 )
     * Space Complexity: O( N )
     * 
     * where N is the size of array 'A'.
     */
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        int n = a.length;

        List<List<Integer>> ans = new ArrayList<>();
        // This will keep all those sub-arrays whose sum = 'k'.

        // Iterating over 'a'
        for (int i = 0; i < n; ++i) {
            long currentSum = 0l;

            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < n; ++j) {
                temp.add(a[j]);
                currentSum += a[j];

                if (currentSum == k) {
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
}
