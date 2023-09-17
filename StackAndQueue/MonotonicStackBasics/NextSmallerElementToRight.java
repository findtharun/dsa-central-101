package StackAndQueue.MonotonicStackBasics;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToRight {

    public static int[] nextSmallerElementToRightBruteForce(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] nextSmallerElementToRight(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                res[st.pop()] = nums[i];
            }
            st.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };
        int[] result = nextSmallerElementToRight(nums);
        // int[] result = nextSmallerElementToRightBruteForce(nums);
        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
