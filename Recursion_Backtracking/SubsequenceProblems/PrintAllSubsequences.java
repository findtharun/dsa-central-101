package Recursion_Backtracking.SubsequenceProblems;

import java.util.*;

public class PrintAllSubsequences {

    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {
        if (index == arr.length) {
            if (path.size() > 0)
                System.out.println(path);
        } else {
            printSubsequences(arr, index + 1, new ArrayList<>(path)); // Do Not Take Current Element
            path.add(arr[index]); // Take the Current Element
            printSubsequences(arr, index + 1, new ArrayList<>(path));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(arr, 0, path);
    }
}
