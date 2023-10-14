package Searching.BinarySearch.FirstAndLastOccurence;

public class BinarySearch {
    public int firstOcc(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    public int lastOcc(int[] nums, int target, int n) {
        int low = 0;
        int high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int arr[] = { -1, -1 };
        int n = nums.length;
        int first = firstOcc(nums, target, n);
        if (first == -1)
            return arr;
        int last = lastOcc(nums, target, n);
        arr[0] = first;
        arr[1] = last;
        return arr;
    }
}
