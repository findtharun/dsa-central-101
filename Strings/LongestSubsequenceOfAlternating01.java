package Strings;

public class LongestSubsequenceOfAlternating01 {
    public static void main(String[] args) {
        int maxLength = -1;
        int startIndex = 0;
        String S = "10010";
        // current alternating series begins at startIndex and ends at i+1, not i.
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                if (maxLength < i + 1 - startIndex + 1) {
                    maxLength = i + 1 - startIndex + 1;
                    startIndex = i;
                }
            } else {
                startIndex = i + 1; 
            }
        }
        int endIndex = startIndex + maxLength - 1;
        System.out.println(maxLength);
    }
}
