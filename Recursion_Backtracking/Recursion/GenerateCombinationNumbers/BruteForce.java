package GenerateCombinationNumbers;

import java.util.*;

public class BruteForce {

    public static void main(String[] args) {
        // Define the ranges
        int[] range1 = { 2, 3 };
        int[] range2 = { 4, 5 };
        int[] range3 = { 6, 7 };

        // Initialize a list to store the results
        List<String> results = new ArrayList<>();

        // Brute force solution using three loops
        for (int i = range1[0]; i <= range1[1]; i++) {
            for (int j = range2[0]; j <= range2[1]; j++) {
                for (int k = range3[0]; k <= range3[1]; k++) {
                    results.add("" + i + j + k);
                }
            }
        }

        // Print the results
        for (String number : results) {
            System.out.println(number);
        }
    }
}
