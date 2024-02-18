package Recursion_Backtracking.SubsequenceProblems;

import java.util.*;

/*
 * https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/
 */
public class SubsequencesWithSumK {
    public static void subSequenceSum(int a[], int ind, ArrayList<Integer> currSeq, int currSum, int k, List<List<Integer>> ans) {
        if (ind == a.length) {
            if (currSum == k) {
                ans.add(new ArrayList<>(currSeq)); // Create a copy of currSeq before adding to ans
            }
            return;
        }

        // Include the current element
        currSum += a[ind];
        currSeq.add(a[ind]);
        subSequenceSum(a, ind + 1, currSeq, currSum, k,ans);

        // Exclude the current element
        currSum -= a[ind];
        currSeq.remove(currSeq.size() - 1);
        subSequenceSum(a, ind + 1, currSeq, currSum, k,ans);
    }

    // Driver Code
    public static void main(String args[]) {
        int arr[] = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
        int k = 6;
        List<List<Integer>> ans = new ArrayList<>();
        subSequenceSum(arr, 0, new ArrayList<Integer>(), 0, k, ans);

        // Loop to print the subsequences
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
