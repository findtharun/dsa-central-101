package StackAndQueue.CandyCrush1D.RecursivelyRemoveAdjacentDuplicates;

public class RecursiveApproach {

    public static String rremove(String S) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 1;
        while (r < S.length() && l < r) {
            char ch = S.charAt(l);
            if (ch == S.charAt(r)) {
                while (r < S.length() && ch == S.charAt(r)) {
                    r++;
                }
                l = r;
                if (r < S.length()) {
                    r++;
                }
            } else {
                sb.append(ch);
                l++;
                r++;
            }
        }
        sb.append(S.substring(l)); // Last Character Misses out in Loop hence appending it
        String result = sb.toString();
        // Check if result is different from input
        if (result.equals(S)) {
            return result;
        } else {
            // Recursively call rremove with the updated string
            return rremove(result);
        }
    }

    public static void main(String[] args) {
        String inputString = "abcccbd";
        String outputString = rremove(inputString);
        System.out.println("Output: " + outputString);
    }
}
