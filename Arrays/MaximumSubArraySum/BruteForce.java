package Arrays.MaximumSubArraySum;

public class BruteForce {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}
