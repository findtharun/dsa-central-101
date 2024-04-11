package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;
// This approach can only give length not subsequence, Standard Approach is preferred for printing Subsequence.
public class BinarySearchApproach {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1))
                temp.add(nums[i]);
            else {
                /*
                 * in java it returns the index of the search key, if it is contained in the
                 * array. otherwise, (-(insertion point) – 1).
                 */
                int pos = Collections.binarySearch(temp, nums[i]);
                if (pos < 0)
                    pos = Math.abs(pos) - 1;
                temp.set(pos, nums[i]);
            }
        }
        return temp.size();
    }
}
