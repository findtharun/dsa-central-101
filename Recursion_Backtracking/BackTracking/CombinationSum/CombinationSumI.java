package Recursion_Backtracking.BackTracking.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    public static void backTrack(int[] candidates, int start, List<Integer> currSeq, int target,
            List<List<Integer>> res) {
        if (target < 0)
            return;
        else if (target == 0) {
            res.add(new ArrayList<>(currSeq));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                currSeq.add(candidates[i]);
                backTrack(candidates, i, currSeq, target - candidates[i], res);
                currSeq.remove(currSeq.size() - 1);
            }
        }
    }
    // The Below Code is Pure Recursion Approach similar to Generating Subsequences
    /* public static void backTrack(int[] candidates, int ind, List<Integer> currSeq,int target,List<List<Integer>> res){
        if(ind == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(currSeq));  
            }
            return;
        }
        // Taking Same Element Multiple Time
        if(candidates[ind] <= target){
            currSeq.add(candidates[ind]);
            backTrack(candidates,ind,currSeq,target-candidates[ind],res);
            currSeq.remove(currSeq.size()-1); // Removing Same Element
        }
        backTrack(candidates,ind+1,currSeq,target,res); // Not Taking the Same Element
    }
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }
}
