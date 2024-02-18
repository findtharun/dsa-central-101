package Recursion_Backtracking.BackTracking.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void backTrack(int start, List<Integer> currSeq, int k, int target, List<List<Integer>> res) {
        if (currSeq.size() > k)
            return;
        else if (currSeq.size() == k && target == 0) {
            res.add(new ArrayList<>(currSeq));
        } else {
            for (int i = start; i <= 9; i++) {
                currSeq.add(i);
                backTrack(i + 1, currSeq, k, target - i, res);
                currSeq.remove(currSeq.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(1, new ArrayList<>(), k, n, res);
        return res;
    }
}
