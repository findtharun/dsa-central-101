package Heaps.Implementations;

import java.util.*;

// Simply build Max Heap without caring about the min Heap (i.e utilize the given array)
/*
 * start from the bottom-most and rightmost internal node of Min-Heap and heapify all internal nodes in the bottom-up way to build the Max heap.
 */
public class MinToMaxHeap {
    private static void swap(int i, int j, int[] heap) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static void heapifyDown(int[] heap, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest, heap);
            heapifyDown(heap, largest, size);
        }
    }

    // NOTE : Index of First Leaf in Heap / Complete Binary tree is (n/2 - 1).
    public static void minToMaxHeap(int[] heap, int N) {
        for (int i = (N - 2) / 2; i >= 0; --i)
            heapifyDown(heap, i, N);
    }

    public static void main(String[] args) {
        // array representing Min Heap
        int heap[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
        int N = heap.length;

        System.out.print("Min Heap array : ");
        System.out.println(Arrays.toString(heap));

        // Function call
        minToMaxHeap(heap, N);

        System.out.print("Max Heap array : ");
        System.out.println(Arrays.toString(heap));
    }
}
