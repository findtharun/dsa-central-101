package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK;

public class Recursion {
    public static boolean hasSubsetSum(int[] arr, int ind, int k) {
        // Base Cases
        if (ind == arr.length) {
            if (k == 0)
                return true;
            return false;
        }

        // If current element is greater than sum, then ignore it
        boolean notTaken = hasSubsetSum(arr, ind + 1, k);
        boolean taken = false;
        if (arr[ind] <= k)
            taken = hasSubsetSum(arr, ind + 1, k - arr[ind]);
        if (arr[ind] > k)
            return hasSubsetSum(arr, ind + 1, k);

        // Check if sum can be obtained by including the current element or excluding it
        return notTaken || taken;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        return hasSubsetSum(arr, 0, k);
    }
}
