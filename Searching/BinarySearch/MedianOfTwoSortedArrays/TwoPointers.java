package Searching.BinarySearch.MedianOfTwoSortedArrays;

public class TwoPointers {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int[] res = new int[nums1.length + nums2.length];
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2])
                res[i++] = nums1[p1++];
            else
                res[i++] = nums2[p2++];
        }
        while (p1 < nums1.length) {
            res[i++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            res[i++] = nums2[p2++];
        }
        int n = res.length;
        int mid = n / 2;
        System.out.println(res[mid]);
        if ((n % 2) == 0) {
            return (double) (res[mid] + res[mid - 1]) / 2;
        }
        return res[mid];
    }
}
