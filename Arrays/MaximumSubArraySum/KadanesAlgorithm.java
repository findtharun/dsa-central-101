package Arrays.MaximumSubArraySum;

public class KadanesAlgorithm {
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // maxEndingHere is the maximum sum of subarray ending at index i
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // maxSoFar keeps track of the maximum sum found so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maxSubArraySum(nums);
        System.out.println("Maximum sum of a contiguous subarray is " + maxSum);
    }
}
