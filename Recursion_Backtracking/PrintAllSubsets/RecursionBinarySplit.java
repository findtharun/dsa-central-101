package Recursion_Backtracking.PrintAllSubsets;

import java.util.ArrayList;
import java.util.List;

public class RecursionBinarySplit {
    public static void backTrack(int[] nums, int ind, List<Integer> currSubset, List<List<Integer>> res) {
        if (ind == nums.length) {
            res.add(new ArrayList<>(currSubset));
            return;
        }
        // Take
        currSubset.add(nums[ind]);
        backTrack(nums, ind + 1, currSubset, res);
        // Not Take
        currSubset.remove(currSubset.size() - 1);
        backTrack(nums, ind + 1, currSubset, res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = subsets(nums); 
        System.out.println(res);
    }
}
