package StackAndQueue.MaxStack;

import java.util.Stack;
// Explanation : https://www.youtube.com/watch?v=SyDmmNQFW_I
public class Intuitive {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public Intuitive() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        int currMaxVal = x;
        if (!maxStack.isEmpty()) {
            currMaxVal = Math.max(currMaxVal, maxStack.peek());
        }
        maxStack.push(currMaxVal);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();

        // Pop elements from stack until we find the max element
        while (top() != max) {
            buffer.push(pop());
        }

        // Remove the max element from the stack
        pop();

        // Push the elements back to the stack
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
