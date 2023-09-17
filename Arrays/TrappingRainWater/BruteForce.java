package Arrays.TrappingRainWater;

public class BruteForce {
    public int findMaxInArraySlice(int start, int end, int[] height) {
        int max_height = 0;
        for (int i = start; i < end; i++) {
            max_height = Math.max(height[i], max_height);
        }
        return max_height;
    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        if (n < 3)
            return res;
        for (int i = 0; i < n; i++) {
            int max_left = findMaxInArraySlice(0, i + 1, height);
            int max_right = findMaxInArraySlice(i + 1, n, height);
            res = res + Math.max(0, Math.min(max_left, max_right) - height[i]);
        }
        return res;
    }
}
