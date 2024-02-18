package Recursion_Backtracking.BackTracking.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void backTrack(int[] candidates, int start, List<Integer> currSeq, int target,
            List<List<Integer>> res) {
        if (target < 0)
            return;
        else if (target == 0) {
            res.add(new ArrayList<>(currSeq));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue; // Skip Duplicates, Go to Next Loop
                currSeq.add(candidates[i]);
                backTrack(candidates, i + 1, currSeq, target - candidates[i], res);
                currSeq.remove(currSeq.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sorting Elemenates Duplicates easily and also gives res in Lexographical Order
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }
}
