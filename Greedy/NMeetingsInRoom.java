package Greedy;
// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class NMeetingsInRoom {
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }
        Collections.sort(meet, new Comparator<meeting>() {
            public int compare(meeting e1, meeting e2) {
                // if end dates are same return the first pos
                if (e1.end == e2.end)
                    return e1.pos - e2.pos;
                // We are trying to sort in ascending order
                else
                    return e1.end - e2.end;
            }
        });

        ArrayList<Integer> res = new ArrayList<>();
        // First Meeting will always be performed
        res.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        // Checking from Second Meeting
        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                res.add(meet.get(i).pos);
            }
        }
        return res.size();
    }
}
