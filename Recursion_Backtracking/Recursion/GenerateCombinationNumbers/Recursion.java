package GenerateCombinationNumbers;

import java.util.*;

public class Recursion {
    public static void generateNumbers(int[][] ranges, String curr, int index, List<String> ans) {
        if (index == ranges.length) {
            ans.add(curr);
            return;
        }
        // Get the start and end of the current range
        int start = ranges[index][0];
        int end = ranges[index][1];

        // Loop through all numbers in the current range
        for (int num = start; num <= end; num++) {
            generateNumbers(ranges, curr+num, index + 1, ans);
        }
    }

    public static void main(String[] args) {
        int[][] ranges = { { 2, 3 }, { 4, 5 }, { 4, 5 } };
        List<String> ans = new ArrayList<>();
        generateNumbers(ranges, "", 0, ans);
        for (String val : ans)
            System.out.println(val);
    }
}
