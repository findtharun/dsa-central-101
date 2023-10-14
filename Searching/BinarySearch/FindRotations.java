package Searching.BinarySearch;
//https://www.codingninjas.com/studio/problems/rotation_7449070

// This Problem Can be Found using Search Minimum in Sorted Array, Minimum element is the Point 
// Where Rotation Occurs, Index is the Answer
public class FindRotations {
    public static int findKRotation(int[] arr) {
        // Write your code here.
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        int k = -1;
        int minimum = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                if (arr[low] < minimum) {
                    k = low;
                    minimum = arr[low];
                }
                low = mid + 1;

            } else {
                high = mid - 1;
                if (arr[mid] < minimum) {
                    k = mid;
                    minimum = arr[mid];
                }
            }
        }
        return k;
    }
}
