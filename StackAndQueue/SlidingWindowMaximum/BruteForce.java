package StackAndQueue.SlidingWindowMaximum;

public class BruteForce {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[n - k + 1];
        // BruteForce Time Limit Exceeded
        for (int i = 0; i < n - k + 1; i++) {
            int max_value_in_curr_window = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max_value_in_curr_window = Math.max(max_value_in_curr_window, nums[j]);
            window[i] = max_value_in_curr_window;
        }
        return window;
    }
}