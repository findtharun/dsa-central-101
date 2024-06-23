package StackAndQueue.CandyCrush1D;

import java.util.Stack;

public class TwoStacks {
    public static String rremove(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> occurance = new Stack<>();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) {
                if (!stack.isEmpty() && occurance.peek() >= 2) {
                    stack.pop();
                    occurance.pop();
                } else {
                    stack.push(c);
                    occurance.push(1);
                    i++;
                }
            } else {
                int count = occurance.pop();
                occurance.push(count + 1);
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String inputString = "abcccbd";
        String outputString = rremove(inputString);
        System.out.println("Output: " + outputString);
    }
}
