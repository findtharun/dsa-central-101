package DynamicProgramming.DP1D.DecodeWays;

public class Recursion {
    public int numDecodings(String s) {
        return recursiveDecode(s, 0);
    }
    private int recursiveDecode(String s, int index) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }

        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }

        // Decode single digit
        int ways = recursiveDecode(s, index + 1);

        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += recursiveDecode(s, index + 2);
        }
        return ways;
    }
}
