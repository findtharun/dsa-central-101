package Arrays;

public class MaxProductSubarray {
    // Best Explanation : https://www.youtube.com/watch?v=Y6B-7ZctiW8
    public int maxProduct(int[] nums) {
        /**
         * All Cases Boil downs to Solving For Odd Number of Negative Values
         * In that case we either have to remove the negative from first or last to
         * maximize result
         */
        int n = nums.length;
        double pre = 1;
        double suff = 1;
        double ans = nums[0]; // Double because during multiplication Number will be > Int
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre = pre * nums[i];
            suff = suff * nums[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return (int) ans;
    }
}
