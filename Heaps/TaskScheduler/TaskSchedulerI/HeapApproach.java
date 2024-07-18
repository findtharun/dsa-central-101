package TaskScheduler.TaskSchedulerI;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/ (Other Solutions are efficient as well , can be found in leetcode editorial)
public class HeapApproach {
    public int leastInterval(char[] tasks, int n) {
        // Build frequency map
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            for (int frequency : store)
                pq.add(frequency);
            // Add time for the completed cycle
            if (pq.isEmpty())
                time = time + taskCount; // Only executes at Last cycle
            else
                time = time + n + 1; // A Full Cycle completed
        }
        return time;
    }
}
