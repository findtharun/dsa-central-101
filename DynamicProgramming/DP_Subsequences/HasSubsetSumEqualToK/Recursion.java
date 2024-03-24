package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK;

public class Recursion {
    public static boolean hasSubsetSum(int[] arr, int ind, int k) {
        // Base Cases
        if (k == 0)
            return true;
        if (ind == arr.length) // We have Explored all Ways on that path but no subset has been found , If it has found it would have been returned at before line
            return false;

        // If current element is greater than sum, then ignore it
        if (arr[ind] > k)
            return hasSubsetSum(arr, ind + 1, k);

        // Check if sum can be obtained by including the current element or excluding it
        return hasSubsetSum(arr, ind + 1, k) || hasSubsetSum(arr, ind + 1, k - arr[ind]);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        return hasSubsetSum(arr, 0, k);
    }
}
