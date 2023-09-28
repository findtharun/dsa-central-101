package Strings;

import java.util.ArrayList;
import java.util.Stack;

// Problem  : https://leetcode.com/problems/remove-outermost-parentheses/
// Solution Approach : https://www.youtube.com/watch?v=Evrdo1JEnmo
public class RemoveOuterMostParentheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                indices.add(i);
            } else {
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        indices.add(i);
                    }
                } else if (stack.peek() == ')' && s.charAt(i) == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        indices.add(i);
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        System.out.println(indices);
        // We store indices in consecutive values (start and end) So Iterating i+2
        for (int i = 0; i < indices.size(); i = i + 2) {
            int start = indices.get(i) + 1; // Since we need to remove the outermost
            int end = indices.get(i + 1);
            ans.append(s.substring(start, end));
        }
        return ans.toString();
    }
}
