package Searching.BinarySearch.SingleInSorted;

public class BruteForce {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int res = nums[n - 1];
        if (n == 1)
            return nums[0];
        for (int i = 0; i < n - 1; i++) {
            if (i == 0 && nums[i] != nums[i + 1])
                return nums[i];
            else if (i == n - 1 && nums[i] != nums[i - 1])
                return nums[i];
            else {
                if ((nums[i] != nums[i + 1]) && (nums[i] != nums[i - 1])) {
                    res = nums[i];
                    break;
                }
            }
        }
        return res;
    }
}
