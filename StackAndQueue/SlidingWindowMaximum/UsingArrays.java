package StackAndQueue.SlidingWindowMaximum;

public class UsingArrays {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0)
                left[i] = nums[i]; // block start
            else
                left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0)
                right[j] = nums[j]; // block end
            else
                right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }
}
