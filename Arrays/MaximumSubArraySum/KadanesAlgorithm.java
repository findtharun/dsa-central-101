package Arrays.MaximumSubArraySum;

public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int maxStart = -1;
        int maxEnd = -1; // These Values are used to Store the Indices
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum = sum + nums[i];
            if (sum > maxi) {
                maxi = sum;
                maxStart = start;
                maxEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}
