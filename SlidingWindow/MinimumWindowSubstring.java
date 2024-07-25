package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length();
        int n = s.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (end < n) {
            char curr = s.charAt(end);
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0)
                    count--; // A valid character in t is matched
                map.put(curr, map.get(curr) - 1);
            }
            end++;
            // When all characters in t are matched
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // Shrinking Window
                char tempC = s.charAt(start);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : s.substring(startIndex, startIndex + minLen);
    }
}
