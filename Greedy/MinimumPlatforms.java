package Greedy;

import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

// Bruteforce would be O(N^2), We Take one Interval and compare with all.

public class MinimumPlatforms {
    public int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
                result = Math.max(result, plat_needed);
            }
            // Else decrement count of platforms needed
            else {
                plat_needed--;
                j++;
            }
        }
        return result;
    }
}
