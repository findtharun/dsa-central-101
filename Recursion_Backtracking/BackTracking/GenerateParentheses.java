package Recursion_Backtracking.BackTracking;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesisAns(String p, int open, int close, int n, ArrayList<String> list) {
        if (open == n && close == n) { // We are Achieving solution while tracing back
            list.add(p);
            return list;
        }

        if (open < n) {
            generateParenthesisAns(p + "(", open + 1, close, n, list);
        }
        if (close < open) {
            generateParenthesisAns(p + ")", open, close + 1, n, list);
        }

        return list;
    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesisAns("", 0, 0, n, new ArrayList<>());
    }
}
