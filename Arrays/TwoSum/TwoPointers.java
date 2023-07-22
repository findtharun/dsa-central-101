package Arrays.TwoSum;

import java.util.*;

public class TwoPointers {
    int[] func(int[] nums, int n, int target) {
        // Write your code here
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nums[i];
        int[] res = new int[2];
        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;
        int sum = 0;
        int a = -1, b = -1;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum == target) {
                a = nums[l];
                b = nums[r];
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        for (int ind = 0; ind < n; ind++) {
            if (arr[ind] == a && res[0] == 0)
                res[0] = ind;
            else if (arr[ind] == b)
                res[1] = ind;
        }

        return res;
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
