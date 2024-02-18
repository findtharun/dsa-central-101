package Recursion_Backtracking;
import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
    public static void generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        generateSubsets(nums); 
    }
}
