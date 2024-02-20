package Recursion_Backtracking.BackTracking.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetII {
    private void backTrack(int[] nums, int start, List<Integer> currSubset, List<List<Integer>> res) {
        res.add(new ArrayList<>(currSubset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue; // skip duplicates i> start ensure we don't remove the first occuring element
            currSubset.add(nums[i]);
            backTrack(nums, i + 1, currSubset, res);
            currSubset.remove(currSubset.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
}
