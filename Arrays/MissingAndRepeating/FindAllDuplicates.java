package Arrays.MissingAndRepeating;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int absVal = Math.abs(nums[i]);
            if (nums[absVal - 1] > 0) {
                nums[absVal - 1] = -nums[absVal - 1];
            } else {
                ans.add(nums[absVal]);
            }
        }
        return ans;
    }
}
