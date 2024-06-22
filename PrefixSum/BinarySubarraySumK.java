package PrefixSum;

import java.util.*;

public class BinarySubarraySumK {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currentSum = 0;
        // {prefix: number of occurrence}
        Map<Integer, Integer> freq = new HashMap<>(); // To store the frequency of prefix sums
        for (int num : nums) {
            currentSum += num;
            if (currentSum == goal) {
                totalCount++;
            }

            // Check if there is any prefix sum that can be subtracted from the current sum
            // to get the desired goal
            if (freq.containsKey(currentSum - goal)) {
                totalCount += freq.get(currentSum - goal);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }
        return totalCount;
    }
}
