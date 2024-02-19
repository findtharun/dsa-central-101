package Recursion_Backtracking.PrintAllSubsets;

import java.util.ArrayList;
import java.util.List;

public class IterativeApproach {

    // Iterative Approach
    /*
     * subsets = [[]]
     * for n in nums:
     * for i in range(len(subsets)):
     * subsets += [subsets[i]+[n]]
     * return subsets
     */
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int size = res.size();

            for (int j = 0; j < size; j++) {
                List currSubset = res.get(j);
                List newSubset = new ArrayList(currSubset);
                newSubset.add(num);
                res.add(newSubset);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
