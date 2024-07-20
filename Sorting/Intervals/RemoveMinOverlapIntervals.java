package Sorting.Intervals;

import java.util.Arrays;
// https://leetcode.com/problems/non-overlapping-intervals/
public class RemoveMinOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // If there is Overlap, We keep which ends first and remove which ends later
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart >= prevEnd) {
                // Not Overlapping
                prevEnd = currEnd;
            } else {
                // Overlapping hence we need to remove
                ans++;
                // We are removing the Interval Which ends later,
                // Hence considering minEnd for next Iteration
                prevEnd = Math.min(currEnd, prevEnd);
            }
        }
        return ans;
    }
}
