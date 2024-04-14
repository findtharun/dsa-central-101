package Heaps;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/
import java.util.*;

public class KthLargestElementInStream {
    // The constructor initializes the min heap with the first k elements from the
    // given array, and then for each subsequent element,
    // if it is larger than the smallest element in the min heap (i.e., the root of the min heap),
    // it is added to the heap and the smallest element is removed
    private PriorityQueue<Integer> minHeap;
    private int k;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int ele : nums)
            minHeap.add(ele);
        while (minHeap.size() > k)
            minHeap.poll();
        // minHeap.peek() would give kth Largest since we deleted smaller ones.
    }

    public int add(int val) {
        if (minHeap.size() < k)
            minHeap.add(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
