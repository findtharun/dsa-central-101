package Sorting.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // Sorting based on Start values, if Equal based on end Values
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        List<int[]> answer = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                answer.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        answer.add(new int[] { start, end });
        return answer.toArray(new int[answer.size()][]);
    }
}
