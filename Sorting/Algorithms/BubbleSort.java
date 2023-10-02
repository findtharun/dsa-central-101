package Sorting.Algorithms;

// Greatest Element is Placed Towards End in Each Pass
public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        boolean isSwapped; // To check if array is already sorted, if Yes then Break out of loop to reduce Time
        for (int i = 0; i < n - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false)
                break;
        }
    }
}
