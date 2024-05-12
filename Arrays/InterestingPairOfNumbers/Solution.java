package Arrays.InterestingPairOfNumbers;

public class Solution {

    static int pairs(int[] nums, int sumVal) {
        // sum can only be even
        if (sumVal % 2 != 0)
            return 0;
            sumVal /= 2;
        // Find the number of elements whose absolute value is less than sum/2 and equal
        // to sumVal/2
        int less = 0, same = 0;
        for (int x : nums) {
            int p = Math.abs(x);
            if (p == sumVal)
                same++;
            if (p < sumVal)
                less++;
        }
        // 1. we can pick every less element for every same element(i,j)
        // 2. we can pick any pair of same element
        return less * same + (same * (same - 1)) / 2;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, -1, 2 };
        int sumVal = 4;
        System.out.println("total number of pairs are : " + pairs(nums, sumVal));
    }
}