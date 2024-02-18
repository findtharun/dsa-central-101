package Recursion_Backtracking;

import java.util.*;

public class PrintAllSubsequences {

    public static void printSubsequencesCleanCode(int[] arr, int index, ArrayList<Integer> path) {
        if (index == arr.length) {
            if (path.size() > 0)
                System.out.println(path);
        } else {
            printSubsequences(arr, index + 1, new ArrayList<>(path)); // Do Not Take Current Element
            path.add(arr[index]); // Take the Current Element
            printSubsequences(arr, index + 1, new ArrayList<>(path));
        }
    }

    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {
        if (index == arr.length) {
            if (path.size() > 0)
                System.out.println(path);
        } else {
            path.add(arr[index]); // Take the Current Element
            printSubsequences(arr, index + 1, path); 
            path.remove(path.size()-1); // Do Not Take Current Element
            printSubsequences(arr, index + 1, path);
        }
    }

    public static void printSubsequencesIterative(int[] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3,1,2 };
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(arr, 0, path);
    }
}
