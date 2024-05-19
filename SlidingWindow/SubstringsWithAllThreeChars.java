package SlidingWindow;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 * It is solved using Sliding Window and Two Pointers - Proper Interview Question
 * Explanation : https://www.youtube.com/watch?v=InUwhA2rcfA
 */
public class SubstringsWithAllThreeChars {
    public int numberOfSubstrings(String s) {
        int[] abc = new int[3];
        int n = s.length();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < n; end++) {
            abc[s.charAt(end) - 'a']++;
            while (abc[0] >= 1 && abc[1] >= 1 && abc[2] >= 1) {
                // We can get n-end substrings if consider window of at leaset end
                ans = ans + (n - end);
                // Decrease the window
                abc[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return ans;
    }
}
