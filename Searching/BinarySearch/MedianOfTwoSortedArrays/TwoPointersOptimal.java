package Searching.BinarySearch.MedianOfTwoSortedArrays;

public class TwoPointersOptimal {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1 = -1;
        int m2 = -1;
        int i = 0;
        int j = 0;
        // In m1 we store Mid
        // In m2 We Store Mid -1
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int count = 0; count <= (n1 + n2) / 2; count++) {
            m2 = m1;
            if (i != n1 && j != n2) {
                if (nums1[i] > nums2[j])
                    m1 = nums2[j++];
                else
                    m1 = nums1[i++];
            } else if (i < n1) {
                m1 = nums1[i++];
            } else
                m1 = nums2[j++];
        }
        if ((n1 + n2) % 2 == 0)
            return (double) ((m1 + m2) / 2.0);
        return (double) m1;
    }
}
