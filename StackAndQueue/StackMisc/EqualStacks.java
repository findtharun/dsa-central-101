package StackAndQueue.StackMisc;

import java.util.List;
import java.util.Stack;
//https://www.hackerrank.com/challenges/equal-stacks/problem
public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        int st1_sum = 0;
        int st2_sum = 0;
        int st3_sum = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            st1_sum += h1.get(i);
            st1.push(st1_sum);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            st2_sum += h2.get(i);
            st2.push(st2_sum);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            st3_sum += h3.get(i);
            st3.push(st3_sum);
        }
        while (true) {
            if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty()) {
                return 0;
            }
            int st1TotalHeight = st1.peek();
            int st2TotalHeight = st2.peek();
            int st3TotalHeight = st3.peek();
            if (st1TotalHeight == st2TotalHeight && st2TotalHeight == st3TotalHeight)
                return st1TotalHeight;
            if (st1TotalHeight >= st2TotalHeight && st1TotalHeight >= st3TotalHeight)
                st1.pop();

            if (st2TotalHeight >= st1TotalHeight && st2TotalHeight >= st3TotalHeight)
                st2.pop();
            if (st3TotalHeight >= st1TotalHeight && st3TotalHeight >= st2TotalHeight)
                st3.pop();
        }

    }
}
