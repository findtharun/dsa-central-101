package StackAndQueue.MonotonicStackBasics;

import java.util.*;

public class NextGreaterElementToLeft {
    public static int[] nextGreaterElementsToLeftBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Initialize the result for the current element to -1
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j]; // Update the result if a greater element is found to the left
                    break;
                }
            }
        }

        return result;
    }

    public static int[] nextGreaterElementsToLeft(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize the result array with -1
        Stack<Integer> stack = new Stack<>(); // Create a stack to store indices

        // Iterate through the nums array in reverse
        for (int i = n - 1; i >= 0; i--) {
            // While the stack is not empty and the current element is greater
            // than the element at the index stored in the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // Update the result for the element at the index in the stack
                result[stack.pop()] = nums[i];
            }
            // Push the current element's index onto the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };
        int[] result = nextGreaterElementsToLeft(nums);
        // int[] result = nextGreaterElementsToLeftBruteForce(nums);
        // Print the result
        System.out.println(Arrays.toString(result));
    }
}