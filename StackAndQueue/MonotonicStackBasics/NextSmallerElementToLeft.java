package StackAndQueue.MonotonicStackBasics;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToLeft {
    public static int[] nextSmallerElementToLeftBruteForce(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j]<arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }
    public static int[] nextSmallerElementToLeft(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                res[stack.pop()] =  nums[i];
            }
            // Push the current element's index onto the stack
            stack.push(i);
        }
        return res;
    }
     public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };
        // int[] result = nextGreaterElement(nums);
        // int[] result = nextSmallerElementToLeft(nums);
        int[] result = nextSmallerElementToLeftBruteForce(nums);
        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
