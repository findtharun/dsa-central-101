package StackAndQueue.CandyCrush1D.RecursivelyRemoveAdjacentDuplicates;

import java.util.Stack;

public class StackApproachFails {
    String rremove(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                // If the current character is the same as the top of the stack, remove it
                while (i < n && s.charAt(i) == stack.peek()) {
                    i++;
                }
                stack.pop();
                i--; // Decrement i to correctly handle the next character after duplicates
            } else {
                // System.out.println(s.charAt(i));
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        String result = sb.toString();
        return result;
    }
}
