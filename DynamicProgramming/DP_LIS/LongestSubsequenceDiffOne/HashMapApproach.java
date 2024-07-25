package DynamicProgramming.DP_LIS.LongestSubsequenceDiffOne;

import java.util.HashMap;
import java.util.Map;

public class HashMapApproach {
    public static int longestSubsequence(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : a) {
            if (map.containsKey(num - 1)) {
                map.put(num, map.get(num - 1) + 1);
            } else {
                map.put(num, 1);
            }
            maxLength = Math.max(maxLength, map.get(num));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a1 = { 2, 3, 1, 4, 3, 5, 6 };
        System.out.println(longestSubsequence(a1)); // Output: 5

        int[] a2 = { 1, 2, 3, 4, 5 };
        System.out.println(longestSubsequence(a2)); // Output: 5

        int[] a3 = { 5, 4, 3, 2, 1 };
        System.out.println(longestSubsequence(a3)); // Output: 1

        int[] a4 = { 10, 9, 8, 7, 6 };
        System.out.println(longestSubsequence(a4)); // Output: 1
    }
}
