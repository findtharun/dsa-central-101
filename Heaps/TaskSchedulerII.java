package Heaps;

import java.util.*;

// https://leetcode.com/problems/task-scheduler-ii/
public class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> nextAvailableDay = new HashMap<>();
        long days = 0;
        for (int t : tasks) {
            days = Math.max(nextAvailableDay.getOrDefault(t, 0L), days);
            nextAvailableDay.put(t, days + space + 1);
            days++;
        }
        return days;
    }
}
