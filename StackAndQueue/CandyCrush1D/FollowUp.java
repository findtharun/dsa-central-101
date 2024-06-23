package StackAndQueue.CandyCrush1D;

import java.util.HashMap;
import java.util.Map;

public class FollowUp {
    static String getShortestString(String str) {
        Map<String, String> shortestMap = new HashMap<>();
        if (str.length() == 0)
            return "";
        if (shortestMap.containsKey(str))
            return shortestMap.get(str);

        String minStr = str;
        for (int i = 0; i < str.length(); i++) {

            // find the index of the first char different from str.charAt(i)
            int j = i + 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j))
                j++;

            String newStr;
            if (j - i >= 3) { // We have more than two of the same characters aside each other

                // find the shortest string excluding the same subsequent characters starting
                // from index i
                if (j == str.length()) {
                    newStr = getShortestString(str.substring(0, i));
                } else {
                    newStr = getShortestString(str.substring(0, i) + str.substring(j));
                }
                if (newStr.length() < minStr.length())
                    minStr = newStr;
            }

        }

        shortestMap.put(str, minStr);
        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(getShortestString("aaabbbc"));
        System.out.println(getShortestString("aabbbacd"));
        System.out.println(getShortestString("aabbccddeeedcba"));
        System.out.println(getShortestString("aaabbbacd"));
    }
}
