package PrefixSum;

import java.util.HashMap;

public class ContiguousArray {
    // https://leetcode.com/problems/contiguous-array
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (nums[i] == 0 ? -1 : 1);
            if (sum == 0) // It means all Values Till this have equal
                maxLen = i + 1;
            else if (map.containsKey(sum))
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLen;
    }
}
