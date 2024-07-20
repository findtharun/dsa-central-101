package Sorting.Intervals;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/insert-interval/
public class NsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // Add all the intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        int end = newInterval[1];
        // Merge all overlapping intervals to one considering newInterval
        while (i < n && intervals[i][0] <= end) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            end = newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);
    }
}
