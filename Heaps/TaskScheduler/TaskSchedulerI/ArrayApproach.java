package TaskScheduler.TaskSchedulerI;

import java.util.Arrays;

public class ArrayApproach {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25] - 1;
        int idleSlots = maxFreq * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots = idleSlots - Math.min(maxFreq, freq[i]);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
