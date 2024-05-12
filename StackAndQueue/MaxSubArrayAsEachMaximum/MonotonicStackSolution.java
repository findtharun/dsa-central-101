package StackAndQueue.MaxSubArrayAsEachMaximum;

import java.util.Stack;

public class MonotonicStackSolution {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 9, 12, 14 };
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        // Finding Count pf Elements Till We find Next Great Element to Left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            left[i] = st.empty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st = new Stack<>();
        // Finding Count pf Elements Till We find Next Great Element to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            right[i] = st.empty() ? n - i : st.peek() - i;
            st.push(i);
        }

        int sum = 0;
        for (int i = 0; i < right.length; i++) {
            System.out.println(left[i] + " " + right[i] + " " + (left[i] + right[i] - 1));
            sum += left[i] + right[i] - 1;// -1 to remove duplicates count for the same element
        }

        System.out.println(sum);
    }
}
