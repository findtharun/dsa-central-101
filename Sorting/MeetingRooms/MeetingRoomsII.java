package Sorting.MeetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/description/
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        // Sorting in Ascending order of start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort By ascending End times such that for new meeting we can check if we can
        // use same room or not
        PriorityQueue<Integer> endTimes = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        endTimes.add(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            // Overlapping
            int lastEndTime = endTimes.peek();
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart >= lastEndTime) {
                // We can use the same Meeting
                endTimes.poll();
            }
            endTimes.add(currEnd);

        }
        return endTimes.size();
    }
}
