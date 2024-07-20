package Searching.BinarySearch.RotatedSortedArray.SearchElement;

public class LastIndex {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // It is in Left Part of Array
            if (nums[mid] == target) {
                ans = mid;
                l = mid + 1;
            }
            // Left Sorted Portion
            if (nums[l] <= nums[mid]) {
                if (nums[l] < target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else { // Right Sorted Portion
                if (nums[mid] < target && target < nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return ans;
    }
}
