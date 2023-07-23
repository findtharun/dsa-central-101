package Arrays.MajorityElement;

import java.util.*;

public class HashMapp {
    int func(int[] nums) {
        int n = nums.length;
        // declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        // storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
        }
        // searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        HashMapp obj = new HashMapp();
        System.out.print("Majority Element : ");
        System.out.print(obj.func(arr));
    }

}
