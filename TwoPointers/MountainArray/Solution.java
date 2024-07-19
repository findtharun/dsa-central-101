package TwoPointers.MountainArray;

// https://leetcode.com/problems/valid-mountain-array/description/
public class Solution {
    public boolean validMountainArray(int[] arr) {
        /**
         * Two people climb from left and from right separately.
         * If they are climbing the same mountain,
         * they will meet at the same point.
         */
        int n = arr.length, i = 0, j = n - 1;
        if (n < 3)
            return false;
        // Strictly Increasing
        while (i + 1 < n && arr[i] < arr[i + 1])
            i++;
        if (i == 0 || i == n - 1)
            return false;
        // Strictly Decreasing
        while (j > 0 && arr[j - 1] > arr[j])
            j--;
        return i == j; // We can return the index as well
    }
}

/**
 * Follow up Can be Elements are Non Strictly Increasing / Decreasing
 * The conditions to be changed
 * 1. arr[i] < arr[i + 1] ---> arr[i] <= arr[i + 1]
 * 2. arr[j - 1] > arr[j] ---> arr[j - 1] >= arr[j]
 */
