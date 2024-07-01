import java.util.ArrayList;
import java.util.List;

public class BinarySearchSlidingWindow {
    public int findLowerBound(int[] arr, int x) {
        int lower_bound = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                lower_bound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lower_bound;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> kClosestElements = new ArrayList<Integer>();
        if (arr.length == k) {
            for (int ele : arr)
                kClosestElements.add(ele);
            return kClosestElements;
        }
        // first or smallest index in a sorted array where value at that index >= x
        int lowerBound = findLowerBound(arr, x); //
        int left = lowerBound - 1;
        int right = lowerBound;
        while (right - left <= k) {
            // Happens when Lower Bound is 0
            if (left == -1) {
                right += 1;
                continue;
            }
            // right == arr.length Happens when all Elements are Lesser than X
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1; // as in this case at first left = right-1, we need to move left to have
                           // elements
            } else {
                right += 1;
            }
        }
        for (int i = left + 1; i < right; i++) {
            kClosestElements.add(arr[i]);
        }
        return kClosestElements;
    }
}
