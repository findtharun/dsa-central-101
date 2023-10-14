package Searching.BinarySearch.SingleInSorted;

public class BinarySearch {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;
        if (n == 1)
            return nums[0];
        if (nums[1] != nums[0])
            return nums[0];
        if (nums[n - 2] != nums[n - 1])
            return nums[n - 1];
        int res = nums[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            // We are at Left
            else if ((mid % 2 == 1 && nums[mid - 1] == nums[mid])
                    || (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
                low = mid + 1; // Eliminate Left
            } else {
                // Elimniate Right
                high = mid - 1;
            }
        }
        return res;
    }
}
