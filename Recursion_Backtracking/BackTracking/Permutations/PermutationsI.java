package Recursion_Backtracking.BackTracking.Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {
    public void backTrack(int[] nums, List<Integer> currPermutation, List<List<Integer>> res) {
        if (currPermutation.size() == nums.length) {
            res.add(new ArrayList<>(currPermutation));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (currPermutation.contains(nums[i]))
                    continue;
                currPermutation.add(nums[i]);
                backTrack(nums, currPermutation, res);
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), res);
        return res;
    }
}
