package Heaps.MedianOfDatastream;

// Count sort, record the appearance frequency of each number. Find the medium of according to the total numbers. O(100) = O(1)
public class FollowUpI {
    int A[] = new int[101], n = 0;

    // O(1)
    public void addNum(int num) {
        A[num]++;
        n++;
    }

    // O(100) = O(1)
    public double findMedian() {
        // find 1st median number
        int count = 0, i = 0;
        while (count < n / 2)
            count += A[i++];

        // find 2nd median number
        int j = i;
        while (count < n / 2 + 1)
            count += A[j++];
        return (n % 2 == 1) ? i : (i - 1 + j - 1) / 2.0;
    }
}
