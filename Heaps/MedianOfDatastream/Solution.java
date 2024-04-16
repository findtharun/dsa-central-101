package Heaps.MedianOfDatastream;

import java.util.*;

public class Solution {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    // Small Elements Group is Max Heap, so that Peek would give mid
    private PriorityQueue<Integer> large = new PriorityQueue<>();

    // Large Elements Group is Min Heap so that Mid of this Group is Peek
    private boolean even = true; // 0 is even, so at start we have even number of elements in Both Heaps
                                 // combined.

    // Do a Dry run to Understand the flow, It will always make sure that
    // Every num in small heap is <= every num in large heap.
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (small.peek() / 2.0) + (large.peek() / 2.0); // To Avoid Integer Flow
        else
            return small.peek();
    }
}
