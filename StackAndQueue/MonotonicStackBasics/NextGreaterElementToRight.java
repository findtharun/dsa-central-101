package StackAndQueue.MonotonicStackBasics;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToRight {
    public static int[] nextGreaterElementBruteForce(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j]; // Update the result if a greater element is found to the right
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) { // If current element is greater than Stack Top, Then pop out store it as the next greater element.
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };
        // int[] result = nextGreaterElement(nums);
        int[] result = nextGreaterElement(nums);
        // Print the result
        System.out.println(Arrays.toString(result));
    }

}
