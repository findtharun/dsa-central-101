package Heaps.Implementations;

public class ImplementMain {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(9);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.extractMin());
        }

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(7);
        maxHeap.insert(1);
        maxHeap.insert(9);

        System.out.println("Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }
}
