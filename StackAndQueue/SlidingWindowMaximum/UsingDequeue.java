package StackAndQueue.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingDequeue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Removing Elements which are Out of Window
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // We insert only Elements in Decreasing Order, Remove Smaller Elements
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1)
                window[ri++] = nums[q.peek()];
        }
        return window;
    }
}
