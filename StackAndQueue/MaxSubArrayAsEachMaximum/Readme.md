Given an array a, create an another array b where b[i] is size of maximum subarray which includes a[i] and a[i] is the maximum element in that subarray.

Return the sum of all elements of array b

Constraints:
Length of array a can go till 10^5

Example:
Input: a: {10, 20, 10, 9, 12, 14}
Output: 17
Explanation: b: {1, 6, 2, 1, 3, 4}

#### Solution

For every element Find Next Greater Element to Left , Next Greater Element to right = ngeL[i] + ngeR[i] - 1