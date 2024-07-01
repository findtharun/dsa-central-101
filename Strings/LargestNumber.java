package Strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number
 * TC - O(N*logN)
 * SC - O(N)
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = nums[i] + "";
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b)); // We need in Descending Order
        return arr[0].equals("0") ? "0" : String.join("", arr);
    }
}
