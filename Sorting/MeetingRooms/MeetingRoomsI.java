package Sorting.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRoomsI {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart < prevEnd)
                return false;
            else {
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        return true;
    }
}
