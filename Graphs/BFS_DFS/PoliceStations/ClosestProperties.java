package Graphs.BFS_DFS.PoliceStations;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Coordinate {
    int coordinate;
    int level;

    public Coordinate(int coordinate, int level) {
        this.coordinate = coordinate;
        this.level = level;
    }
}

public class ClosestProperties {

    public int solve(int n, int[] police, int capacity) {
        PriorityQueue<Coordinate> q = new PriorityQueue<>((a,b) -> a.level - b.level);
        Set<Integer> set = new HashSet<>();

        for (Integer p : police) {
            set.add(p);
            q.add(new Coordinate(p, 0));
        }

        int sum = 0;
        while (!q.isEmpty()) {
            Coordinate co = q.poll();
            int newCo = co.coordinate - 1;
            if (!set.contains(newCo)) {
                sum = sum + co.level + 1;
                set.add(newCo);
                q.add(new Coordinate(newCo, co.level + 1));
                capacity--;
            }
            if (capacity == 0) {
                return sum;
            }
            newCo = co.coordinate + 1;
            if (!set.contains(newCo)) {
                sum = sum + co.level + 1;
                set.add(newCo);
                q.add(new Coordinate(newCo, co.level + 1));
                capacity--;
            }
            if (capacity == 0) {
                return sum;
            }
        }
        return sum;
    }

}
