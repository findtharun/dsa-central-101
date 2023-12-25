package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        // Given Edge List, We are Converting into Adjacency List
        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] topologicalOrder = new int[numCourses];
        int j = 0;
        while (q.size() > 0) {
            int curr_node = q.peek();
            topologicalOrder[j++] = curr_node;
            q.poll();

            for (int outgoingNode : adj.get(curr_node)) {
                inDegree[outgoingNode]--;
                if (inDegree[outgoingNode] == 0)
                    q.offer(outgoingNode);
            }
        }
        if (j != numCourses)
            return new int[0];
        return topologicalOrder;
    }
}
