package Arrays.TwoSum;

import java.util.*;

public class HashMapp {
    int[] func(int[] nums, int n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = -1; ans[1]= -1;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int moreNeeded = target - curr;
            if (map.containsKey(moreNeeded)) {
                ans[0] = nums[i];
                ans[1] = map.get(moreNeeded);
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;

    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;
        TwoPointers obj = new TwoPointers();
        int[] ans = obj.func(arr, n, target);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }

}
