package StackAndQueue.StackMisc;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int maxLength(String S) {
        int n = S.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for the first valid substring
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Remove the last unmatched '('

                if (stack.isEmpty()) {
                    stack.push(i); // Base index for the next valid substring
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
