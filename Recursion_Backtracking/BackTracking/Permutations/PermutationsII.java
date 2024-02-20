package Recursion_Backtracking.BackTracking.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    // Easy Approach
    // private void backtrack(List<List<Integer>> res, List<Integer> currPermutation, int[] nums, boolean[] used) {
    //     if (currPermutation.size() == nums.length && res.contains(currPermutation) == false) {
    //         res.add(new ArrayList<>(currPermutation));
    //     } else {
    //         for (int i = 0; i < nums.length; i++) {
    //             if (used[i])
    //                 continue;
    //             used[i] = true;
    //             currPermutation.add(nums[i]);
    //             backtrack(res, currPermutation, nums, used);
    //             used[i] = false;
    //             currPermutation.remove(currPermutation.size() - 1);
    //         }
    //     }
    // }

    // Optimal Approach
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
