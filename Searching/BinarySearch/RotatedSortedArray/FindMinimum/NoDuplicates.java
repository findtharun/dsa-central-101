package Searching.BinarySearch.RotatedSortedArray.FindMinimum;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class NoDuplicates {
    public int findMin(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Our Min is in Right Part of Array
            if (nums[l] <= nums[mid]) {
                res = Math.min(res, nums[l]);
                l = mid + 1;
            } else {
                // Min in Left Part of Array
                r = mid - 1;
                res = Math.min(res, nums[mid]);
            }
        }
        return res;
    }
}
