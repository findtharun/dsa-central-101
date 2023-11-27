package Greedy.FractionalKnapsack;

import java.util.PriorityQueue;

public class UsingPriorityQueue {
    // Function to get the maximum total value in the knapsack.
    static class Pair implements Comparable<Pair> {
        double ratio;
        int index;

        public Pair(double ratio, int index) {
            this.ratio = ratio;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Double.compare(other.ratio, this.ratio); // Sorts in Descending Order
            // return Double.compare(this.ratio, other.ratio); // Sorts in Ascending Order
        }
    }

    static double fractionalKnapsack(int W, Item[] arr, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            pq.add(new Pair(arr[i].value * 1.0 / arr[i].weight, i));
        }

        double totalValue = 0.0;

        while (!pq.isEmpty() && W > 0) {
            Pair pair = pq.poll();
            int idx = pair.index;

            double fraction = Math.min(1.0, W * 1.0 / arr[idx].weight);
            totalValue += fraction * arr[idx].value;
            W -= fraction * arr[idx].weight;
        }

        return totalValue;
    }
}
