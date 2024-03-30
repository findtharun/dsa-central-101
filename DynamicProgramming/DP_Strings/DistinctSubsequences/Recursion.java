package DynamicProgramming.DP_Strings.DistinctSubsequences;

public class Recursion {
    static int mod = (int) (Math.pow(10, 9) + 7);

    public int helper(int ind1, String s, int ind2, String t) {
        if (ind2 >= t.length())
            return 1;
        if (ind1 >= s.length())
            return 0;
        // If the characters at the current positions match, we can either leave one character from s1
        // or continue to the next character in s1 while staying at the same character in s2.
        if (s.charAt(ind1) == t.charAt(ind2)) {
            int leaveOne = helper(ind1 + 1, s, ind2 + 1, t);
            int stay = helper(ind1 + 1, s, ind2, t);
            return (leaveOne + stay) % mod;
        }else //If the characters don't match, we can only continue to the next character in s1.
            return helper(ind1 + 1, s, ind2, t);
    }
    public int numDistinct(String s, String t) {
        return helper(0, s, 0, t);
    }
}
