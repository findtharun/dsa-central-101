package DynamicProgramming.DP_Strings.ShortestCommonSupersequence;

public class BruteForce {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n1 && j < n2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else {
                sb.append(str1.charAt(i));
                i++;
                sb.append(str2.charAt(j));
                j++;
            }
        }
        while (i < n1) {
            sb.append(str1.charAt(i));
            i++;
        }

        // Append the remaining characters of str2, if any
        while (j < str2.length()) {
            sb.append(str2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
