package DynamicProgramming.DP_Strings.EditDistance;

public class Recursion {
    public int helper(int i, int j, String word1, String word2) {
        if (i >= word1.length()) {
        // We have exhausted Chars in Word1, To Convert we need to use remaining chars in word2
            return word2.length() - j;
        }
        if (j >= word2.length()) {
        // We have exhausted Chars in Word2, To Convert we need to use remaining chars in word1
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) // No Need to Perform any Operation, Go Next Indices in Both
            return helper(i + 1, j + 1, word1, word2);
        else {
            int insertion = 1 + helper(i, j + 1, word1, word2); // Made One Insertion to Match Both Characters
            int deletion = 1 + helper(i + 1, j, word1, word2); // Deleted Character to Match Both
            // Move ve to the next characters in both word1 and word2, effectively replacing
            // a character in word1 with a character from word2
            int replace = 1 + helper(i + 1, j + 1, word1, word2);
            return Math.min(insertion, Math.min(deletion, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        return helper(0, 0, word1, word2);
    }
}
