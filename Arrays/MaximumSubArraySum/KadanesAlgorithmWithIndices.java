package Arrays.MaximumSubArraySum;

public class KadanesAlgorithmWithIndices {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0;
        int maxStart = -1;
        int maxEnd = -1; // These Values are used to Store the Indices
        for (int i = 0; i < n; i++) {
            if (maxEndingHere == 0)
                start = i;
            maxEndingHere = maxEndingHere + nums[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                maxStart = start;
                maxEnd = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
