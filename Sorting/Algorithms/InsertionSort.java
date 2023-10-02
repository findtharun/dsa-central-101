package Sorting.Algorithms;

public class InsertionSort {
    public static void insertionSort(int[] arr, int size) {
        // Your code goes here
        for (int i = 1; i < size; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }
}
