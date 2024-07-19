package TwoPointers.MountainArray;

public class LongestMountainArray {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                // Since it is a Peak, Moving Towards Left and right to find Length
                int left = i - 1;
                int right = i + 1;
                while (left > 0 && arr[left] > arr[left - 1])
                    left--;
                while (right < n - 1 && arr[right] > arr[right + 1])
                    right++;
                longest = Math.max(longest, right - left + 1);
                // We repeat the Same for every peak
            }
        }
        return longest;
    }
}
