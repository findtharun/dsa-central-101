package Searching.BinarySearch.SearchInRotatedArray;
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        // Since Array is Rotated, at any point only one half of array would be sorted
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            // Left Array is Sorted
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else { // Right Array is Sorted
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
