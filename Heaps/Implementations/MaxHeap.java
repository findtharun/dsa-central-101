package Heaps.Implementations;

import java.util.*;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public MaxHeap() {
        this(10); // default capacity
    }

    public void insert(int value) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
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

    public void update(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        int oldValue = heap[index];
        heap[index] = newValue;
        if (newValue > oldValue) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        heap[index] = heap[size - 1]; // Move the last element to the deleted index
        size--; // Decrease the size
        heapifyDown(index); // Heapify from the deleted index downwards
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
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
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}