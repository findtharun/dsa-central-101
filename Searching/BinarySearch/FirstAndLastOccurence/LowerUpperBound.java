package Searching.BinarySearch.FirstAndLastOccurence;

public class LowerUpperBound {
    public int lowerBound(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int lower_bound = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                lower_bound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lower_bound;
    }

    public int upperBound(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int upper_bound = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                upper_bound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upper_bound;
    }

    public int[] searchRange(int[] nums, int target) {
        int arr[] = { -1, -1 };
        int n = nums.length;
        int lower_bound = lowerBound(nums, target, n);
        if (lower_bound == n || nums[lower_bound] != target)
            return arr;
        int upper_bound = upperBound(nums, target, n);
        arr[0] = lower_bound;
        arr[1] = upper_bound - 1;
        return arr;
    }
}
