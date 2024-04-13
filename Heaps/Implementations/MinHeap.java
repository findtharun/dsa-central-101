package Heaps.Implementations;

import java.util.*;

class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public MinHeap() {
        this(10); // default capacity
    }

    /*
     * If the heap is full, it doubles the capacity of the heap array.
     * It adds the new element at the end of the heap array and increments the size.
     * Then, it calls heapifyUp to maintain the heap property by moving the newly
     * added element up the tree until its parent is smaller than it.
     */
    public void insert(int value) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        heap[index] = heap[size - 1]; // Move the last element to the deleted index
        size--; // Decrease the size
        heapifyDown(index); // Heapify from the deleted index downwards
    }

    public void update(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        int oldValue = heap[index];
        heap[index] = newValue;
        if (newValue < oldValue) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    /*
     * This method removes and returns the minimum element (which is always at the
     * root of the Min Heap).
     * It first checks if the heap is empty and throws an exception if so.
     * It swaps the root element with the last element in the heap array and
     * decrements the size.
     * Then, it calls heapifyDown to maintain the heap property by moving the root
     * element down the tree until it is smaller than both of its children.
     */
    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * This method is called after inserting an element to ensure that the heap property is maintained.
     * It takes the index of the newly added element and compares it with its parent.
     * If the newly added element is smaller than its parent, it swaps them and
     * repeats this process until the element reaches the appropriate position in the heap.
     */
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }


    /*
     * This method is called after extracting the minimum element to ensure that the heap property is maintained.
     * It takes the index of the element being moved down and compares it with its children.
     * It finds the smallest child (if any) and swaps the element with the smallest child if it is larger.
     * It repeats this process until the element is smaller than both of its children or until it reaches a leaf node.
     */
    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
