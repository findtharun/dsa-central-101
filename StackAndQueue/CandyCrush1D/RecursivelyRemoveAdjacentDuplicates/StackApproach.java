package StackAndQueue.CandyCrush1D.RecursivelyRemoveAdjacentDuplicates;

import java.util.Stack;

public class StackApproach {
    public static String rremove(String S) {
        Stack<Character> stack = new Stack<>(); // Initialize an empty stack
        int i = 0; // Initialize the index variable

        while (i < S.length()) {
            // Check if stack is not empty and top of stack is the same as S[i]
            while (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                // Remove consecutive characters equal to the top of the stack
                while (i < S.length() && S.charAt(i) == stack.peek()) {
                    i++;
                }
                stack.pop();
            }

            // If S[i] is different from top of the stack, push it onto the stack
            if (i < S.length() && (stack.isEmpty() || stack.peek() != S.charAt(i))) {
                stack.push(S.charAt(i));
                i++;
            }
        }
        // Check if resulting string is the same as the original string
        if (stack.size() == S.length()) {
            // System.out.println("No Operations");
            return S; // There were no Duplicates to be removed hence returning the String
        }

        StringBuilder updatedString = new StringBuilder();
        while (!stack.isEmpty()) {
            updatedString.append(stack.pop());
        }
        return updatedString.reverse().toString();
    }

    public static void main(String[] args) {
        String inputString = "abcccbd";
        String outputString = rremove(inputString);
        System.out.println("Output: " + outputString);
    }
}
