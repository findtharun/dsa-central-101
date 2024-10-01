package Arrays.MergeKSortedArrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeapApproach {
    public int[] mergekSortedArrays(int[][] arrays) {
        int rows = arrays.length;
        Queue<Entry> pq = new PriorityQueue<>(rows);

        int size = 0;
        for (int r = 0; r < rows; r++) {
            if (arrays[r].length > 0) {
                size += arrays[r].length;
                pq.add(new Entry(arrays[r][0], r, 0));
            }
        }

        int[] result = new int[size];

        for (int i = 0; !pq.isEmpty(); i++) {
            Entry curr = pq.poll();
            result[i] = curr.val;

            int nextIndex = curr.index + 1;
            if (nextIndex < arrays[curr.arr].length) {
                pq.add(new Entry(arrays[curr.arr][nextIndex], curr.arr, nextIndex));
            }
        }

        return result;
    }

    private static class Entry implements Comparable<Entry> {
        final int val, arr, index;

        public Entry(int val, int arr, int index) {
            this.val = val;
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(Entry that) {
            return Integer.compare(this.val, that.val);
        }
    }
}